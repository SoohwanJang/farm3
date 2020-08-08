package com.farm.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.farm.web.dao.ItemQnADao;
import com.farm.web.entity.ItemNoticeVo;

@Service
public class ItemQnAService {

	@Autowired
	private ItemQnADao itemQnADao;
	
	
	@Transactional(readOnly = false)
	public List<ItemNoticeVo> plusItemQnA(int itemId, int offset) {
		
		List<ItemNoticeVo> list = itemQnADao.plusTenItemQnA(itemId,offset);
		
		
		return list;
	}

}



