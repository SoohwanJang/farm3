package com.farm.web.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farm.web.dao.BasketDao;
import com.farm.web.dao.MemberDao;
import com.farm.web.dao.OrderDao;
import com.farm.web.dao.OrderItemDao;
import com.farm.web.entity.Basket;
import com.farm.web.entity.BasketPayView;
import com.farm.web.entity.BasketView;
import com.farm.web.entity.Member;
import com.farm.web.entity.Order;
import com.farm.web.entity.OrderItem;
import com.farm.web.entity.OrderSheet;

@Service
public class BasketService {
	@Autowired
	BasketDao basketDao;
	@Autowired
	MemberDao memberDao;
	@Autowired
	OrderDao orderDao;
	@Autowired
	OrderItemDao orderItemDao;

	public int contain(int itemId, int qty, String uName) {
		Member member = memberDao.getFromUid(uName);
		int memberId = member.getId();
		
	
		
		boolean isContain = false;
		
		List<BasketView> basketList = basketDao.getList(memberId);
		for(Basket b : basketList) {
			if(itemId == b.getItemId()) {
		
				isContain = true;
			};
		}
		
		int res = 0;
		if(isContain) {
			res = 2;
		}
		else {
			res = basketDao.insert(itemId,memberId,qty);
		}
		
		return res;
	}

	public int append(int itemId, int qty, String uName) {
		Member member = memberDao.getFromUid(uName);
		int memberId = member.getId();
		
		int cid = 0;
		int cQty = 0;
		
		List<BasketView> basketList = basketDao.getList(memberId);
		for(Basket b : basketList) {
			if(itemId == b.getItemId()) {
				cid = b.getId();
				cQty = b.getQty();
			}
		}
		
		int res = basketDao.update(cid,"qty",cQty+qty);
		
		return res;
	}

	public List<BasketView> getList(String uName) {
		Member member = memberDao.getFromUid(uName);
		int memberId = member.getId();
		
		List<BasketView> bl = basketDao.getList(memberId);
		
		return bl;
	}

	public int delList(int[] selectRows) {
		String idList = "";
		for(int i : selectRows)
			idList += i+",";
		idList = idList.substring(0, idList.length()-1);
		
		return basketDao.delList(idList);
	}

	public int update(int id, int qty) {
		return basketDao.update(id, "qty", qty);
	}

	public boolean isAllContain(String uName, int[] selectRows) {
		boolean res = false;
		
		Member member = memberDao.getFromUid(uName);
		int memberId = member.getId();
		
		String idList = "";
		for(int i : selectRows)
			idList += i+",";
		idList = idList.substring(0, idList.length()-1);
		
		int count = basketDao.getCount(memberId,idList);
		
		if(selectRows.length==count)
			res = true;
		
		return res;
	}

	public List<BasketPayView> getPayList(String uName, int[] selectRows) {
		
		Member member = memberDao.getFromUid(uName);
		int memberId = member.getId();
		
		String idList = "";
		for(int i : selectRows)
			idList += i+",";
		idList = idList.substring(0, idList.length()-1);
		
		return basketDao.getPayList(memberId,idList);
	}

	
	public int order(OrderSheet orderSheet, String uName) {
		int res = 0;
		
		Member member = memberDao.getFromUid(uName);
		int memberId = member.getId();
		
		
		if(orderSheet.getAddressCheck().equals("old"))
			orderSheet.setDestination(member.getAddress());
		
		Order insertOrder = new Order();
		insertOrder.setMemberId(memberId);
		insertOrder.setDestination(orderSheet.getDestination());
		insertOrder.setMemo(orderSheet.getDeliveryMemo());
		insertOrder.setPayMethod(orderSheet.getMethod());
		
		Date now = new Date();
		
		if(orderSheet.getMethod().equals("card")) {
			insertOrder.setCfDate(now);
		}
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(now);
		cal.add(Calendar.DATE, 7);
		insertOrder.setDueDate(cal.getTime());
		
//		order
		orderDao.insert(insertOrder);
		Order order = orderDao.get(memberId);
		
//		orderItem
		OrderItem oi = new OrderItem();
		oi.setOrderId(order.getId());
		
		
		if(orderSheet.getMethod().equals("card")) {
			oi.setStatus("입금완료");
		}
		else {
			oi.setStatus("입금대기");
		}
			
		String[] nums_ = orderSheet.getSelectRows().split(",");
		List<Integer> nums = new ArrayList<>();
		for(String num_ : nums_)
			nums.add(Integer.parseInt(num_));
		
		int insertRow = 0;
		for(int num : nums) {
			//num : basket의 id
			Basket basket = basketDao.get(num);
			oi.setQty(basket.getQty());
			oi.setItemId(basket.getItemId());
			
			insertRow += orderItemDao.insert(oi);
		}
		
		if(insertRow==nums.size())
			res = 1;
		
		String srs = orderSheet.getSelectRows();
		basketDao.delList(srs);
	
		return res;
	}

	public int containforce(int itemId, int qty, String uName) {
		Member member = memberDao.getFromUid(uName);
		int memberId = member.getId();
		
		basketDao.insert(itemId,memberId,qty);
		Basket basket = basketDao.getToMember(memberId);
		int res = basket.getId();
		
		return res;
	}

}
