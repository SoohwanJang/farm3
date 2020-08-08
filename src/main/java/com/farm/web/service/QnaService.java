package com.farm.web.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farm.web.dao.ItemDao;
import com.farm.web.dao.ItemQnADao;
import com.farm.web.dao.MemberDao;
import com.farm.web.entity.Item;
import com.farm.web.entity.ItemQnA;
import com.farm.web.entity.ItemQnAListView;

@Service
public class QnaService {
	
	@Autowired
	private ItemDao itemDao;
	@Autowired
	private ItemQnADao itemQnADao;
	@Autowired
	private MemberDao memberDao;
	
	public List<ItemQnAListView> getQnAList(int id, Integer page, String query, String field){

		int offset = (page-1)*10; // 1-> 0, 2-> 10, 3-> 20 이 되게 만들어야한다.
		int size = 10;
		
	  return itemQnADao.getList(offset, size, id, page, query, field);
	}
	
	public List<Item> getItemList(int id){

		return itemDao.getList2(id);
	}
	
	public int insertAnswer(int id, String data) {
		int result = 0;
		Date cTime = new Date();
	        
	    SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
	    SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");
	    System.out.println("현재시간:"+cTime);    
	    
		result = itemQnADao.update(id, data, cTime);
		
		
		return result;
	}
	
	public ItemQnA getItemQnA(int id) {
		ItemQnA itemQna = itemQnADao.get(id);
		
		return itemQna;
	}
	
	
}
