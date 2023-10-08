package com.resort.springboot.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.resort.springboot.domain.Notice;
import com.resort.springboot.exception.DataNotFoundException;
import com.resort.springboot.repo.NoticeRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional
@Service
public class NoticeService {

	private NoticeRepository noticeRepository;

	@Autowired
	public NoticeService(NoticeRepository noticeRepository) {
		this.noticeRepository = noticeRepository;
	}

//
//	// 날짜
//	@Override
//	public LocalDate date() {
//		LocalDate now = LocalDate.now();
//		return now;
//	}
//
//	// 게시글 임의등록 Test
//	@Override
//	public void insertTest() {
//		for (int i = 1; i <= 20; i++) {
//			Notice notice = new Notice();
//
//			notice.setDate(String.valueOf(date()));
//			notice.setContent("Test 게시글 입니다.");
//			notice.setTitle("Test Title 입니다.");
//			notice.setViewcnt(0);
//
//			noticeRepository.save(notice);
//		}
//	}
//
	// New 게시글 등록
	public void newInsert(String title, String content) {
		
		Notice notice = new Notice();

		// 현재 날짜를 LocalDateTime 객체로 가져오기
		LocalDateTime currentDate = LocalDateTime.now();
		
		// LocalDateTime 객체를 원하는 형식의 문자열로 변환하기
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // 원하는 형식으로 포맷 지정
		String date = currentDate.format(formatter);
		
		// 현재 인증된 사용자 정보 가져오기
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String id = authentication.getName();


		notice.setId(id);
		notice.setTitle(title);
		notice.setContent(content);
		notice.setDate(date);
		notice.setViewcnt(0);
		this.noticeRepository.save(notice);

		noticeRepository.save(notice);
	}

//	
//	@Override // 컬럼 값 수정 update
//	public void update(Notice notice) {
//		Notice notice2 = noticeRepository.findByNoticeId(notice.getNoticeId()).get();
//		// 가져온 글에 수정한 내용을 세팅한다.
//		notice2.setTitle(notice.getTitle());
//		notice2.setContent(notice.getContent());
//
//        // DB에 저장
//		noticeRepository.save(notice2);
//	}
//
	// 전체 게시물 조회
	public List<Notice> getList() {
//		PageRequest pageable = PageRequest.of(0, 10); // 페이지 번호 0부터 시작
//		Page<BoardItem> page = boardRepository.findAll(pageable);
//		return page.getContent();
		return this.noticeRepository.findAll();
	}

//
//	// id값으로 삭제
//	@Override
//	public void deleteId(Long id) {
//		noticeRepository.deleteByNoticeId(id);
//	}
//
	// id값으로 한건 조회
	public Notice oneSelectView(Long noticeId) {
		Optional<Notice> notice = this.noticeRepository.findByNoticeId(noticeId);
		if (notice.isPresent()) {
			return notice.get();
		} else {
			throw new DataNotFoundException("notice not found");
		}
	}

	// id값으로 한건 조회 시 조회수 카운트
	public void visit(Long noticeId) {
		Notice notice = noticeRepository.findByNoticeId(noticeId).orElse(null);
		if (notice != null) {
			notice.setViewcnt(notice.getViewcnt() + 1);
			noticeRepository.save(notice);
		}
	}

}
