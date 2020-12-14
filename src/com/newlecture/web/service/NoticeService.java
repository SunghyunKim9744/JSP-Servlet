package com.newlecture.web.service;

import java.util.List;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.dao.jdbc.JdbcNoticeDao;
import com.newlecture.web.entity.Notice;

public class NoticeService {
	
	private NoticeDao noticeDao;
	
	public NoticeService() {
		
		noticeDao = new JdbcNoticeDao();
	}

	
	public int insert(Notice notice) {
		
		return noticeDao.insert(notice);
	}
	
	public List<Notice> getList(){
		return null;
	}
	public List<Notice> getList(int page, int size, String field, String query) {
		int startIndex = 1+(page-1)*size;
		int endIndex = page*10;
		return noticeDao.getList(startIndex, endIndex, field, query);
	}

	public int hitUp(int id) {
		int result =0;
		Notice notice = noticeDao.get(id);
		notice.setHit(notice.getHit()+1);
		result = noticeDao.update(notice);
		return result;
	}
	
	public int deletaAll(int[] ids) {
		
		int result = 0;
		for(int i=0; i<ids.length; i++) {
			int id= ids[i];
			result += noticeDao.delete(id);
		}
			
		return result;
	}
	
	
	public Notice get(int id) {

		return noticeDao.get(id);
	}

	public int update(Notice notice) {
		
		return noticeDao.update(notice);
	}
	
	public int delete(int id) {
	
		return noticeDao.delete(id);
	}
}
