package com.resort.springboot.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.resort.springboot.domain.Notice;
import com.resort.springboot.domain.NoticeComment;
import com.resort.springboot.repo.NoticeCommentRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional
@Service
public class CommentService {

	private NoticeCommentRepository noticeCommentRepository;

	@Autowired
	public CommentService(NoticeCommentRepository noticeCommentRepository) {
		this.noticeCommentRepository = noticeCommentRepository;
	}

	public void create(Notice notice, String recontent) {

		NoticeComment noticeComment = new NoticeComment();

		// 현재 날짜를 LocalDateTime 객체로 가져오기
		LocalDateTime currentDate = LocalDateTime.now();

		// LocalDateTime 객체를 원하는 형식의 문자열로 변환하기
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // 원하는 형식으로 포맷 지정
		String date = currentDate.format(formatter);
		
		noticeComment.setRecontent(recontent);
		noticeComment.setRedate(date);
		this.noticeCommentRepository.save(noticeComment);

		noticeCommentRepository.save(noticeComment);

	}

}
