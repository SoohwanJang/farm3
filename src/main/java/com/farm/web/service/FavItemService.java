package com.farm.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farm.web.dao.FavItemDao;
import com.farm.web.dao.MemberDao;
import com.farm.web.entity.FavItem;
import com.farm.web.entity.FavItemView;
import com.farm.web.entity.Member;

@Service
public class FavItemService {
	
	@Autowired
	FavItemDao favItemDao;
	@Autowired
	MemberDao memberDao;
	
	public int contain(int itemId, String uName) {
		Member member = memberDao.getFromUid(uName);
		int memberId = member.getId();
		
		int id = 0;
		boolean isContain = false;
		
		List<FavItem> favList = favItemDao.getListTomemberId(memberId);
		for(FavItem fi : favList) {
			if(itemId == fi.getItemId()) {
				id = fi.getId();
				isContain = true;
			}
		}
		
		
		if(isContain) {
			favItemDao.delete(id);
			return 2;
		}
		else {
			favItemDao.insert(itemId,memberId);
			return 1;
		}
	}

}
