package com.kh.second.notice.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.second.notice.dao.NoticeDao;
import com.kh.second.notice.model.vo.Notice;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService	{
	
	@Autowired
	private NoticeDao noticeDao;
	
	@Override
	public ArrayList<Notice> selectList() {
		return noticeDao.selectList();
	}
	
	@Override
	public Notice selectOne(int noticeNo) {
		return noticeDao.selectOne(noticeNo);
	}
	
	@Override
	public int insertNotice(Notice notice) {
		return noticeDao.insertNotice(notice);
	}
	
	@Override
	public int updateNotice(Notice notice) {
		return noticeDao.updateNotice(notice);
	}
	
	@Override
	public int deleteNotice(int noticeNo) {
		return noticeDao.deleteNotice(noticeNo);
	}
	
	@Override
	public ArrayList<Notice> selectNewTop3() {
		return noticeDao.selectNewTop3();
	}
}
