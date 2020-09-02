package com.kh.second.notice.service;

import java.util.ArrayList;
import java.util.List;

import com.kh.second.notice.model.vo.Notice;

public interface NoticeService {
	ArrayList<Notice> selectList();
	Notice selectOne(int noticeNo);
	int insertNotice(Notice notice);
	int updateNotice(Notice notice);
	int deleteNotice(int noticeNo);
	ArrayList<Notice> selectNewTop3();
}
