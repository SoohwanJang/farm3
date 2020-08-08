package com.farm.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farm.web.dao.OriginDao;
import com.farm.web.entity.Origin;

@Service
public class OriginService {

	///지욱///
	@Autowired
	private OriginDao originDao;
	
	public List<Origin> getApiList(int pid){
		return originDao.getApiList(pid);
	}
	////////

}
