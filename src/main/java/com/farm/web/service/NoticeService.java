package com.farm.web.service;

import com.farm.web.dao.NoticeDao;
import com.farm.web.entity.Notice;
import com.farm.web.entity.NoticeView;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeService {

	@Autowired
	private NoticeDao noticeDao;
	
	public List<Notice> getList(Integer page, String field, String query) {
		int size = 10;
		int offset = (page-1)*size;
		
		return noticeDao.getList(offset, size, field, query);
	}

	public Notice get(int id) {
		
		return noticeDao.get(id);
	}
	
	public NoticeView getComm(int id) { //Community Notice 
		
		return noticeDao.getComm(id);
	}

	public int insert(Notice notice) {
		
		return noticeDao.insert(notice);
	}

	public int delete(int[] id) {
		String ids = "";
		for(int i : id)
			ids += i+","; 
		ids = ids.substring(0,ids.length()-1);
		
		return noticeDao.delete(ids);
	}

	public int update(Notice notice) {
		
		return noticeDao.update(notice);
	}

	public int updatePub(int[] id) {
		String ids = "";
		for(int i : id)
			ids += i+","; 
		ids = ids.substring(0,ids.length()-1);
		
		return noticeDao.updatePub(ids);
	}
	
	
}
