package com.farm.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.farm.web.dao.ItemDao;
import com.farm.web.entity.ItemOfDetail;

@Service
public class DetailService {

	
	@Autowired
	private  ItemDao itemDao;
	

	
	@Transactional(readOnly = false)
	public ItemOfDetail init(int prId) {
			
		
		ItemOfDetail itemOfDetail = itemDao.itemOfDetail(prId);
		
		return itemOfDetail;
		
	}

}
