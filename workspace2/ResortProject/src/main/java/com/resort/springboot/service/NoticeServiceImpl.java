package com.resort.springboot.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.resort.springboot.domain.Notice;
import com.resort.springboot.repo.NoticeRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional
@Service
public class NoticeServiceImpl implements NoticeService{

//	private NoticeRepository noticeRepository;
//
//	public NoticeServiceImpl(NoticeRepository noticeRepository) {
//		this.noticeRepository = noticeRepository;
//	}
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
//	// New 게시글 등록
//	@Override
//	public void newInsert(Notice notice) {
//		notice.setViewcnt(0);
//
//		noticeRepository.save(notice);
//	}
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
//	// 전체 게시물 조회
//	@Override
//	public List<Notice> findAll() {
////		PageRequest pageable = PageRequest.of(0, 10); // 페이지 번호 0부터 시작
////		Page<BoardItem> page = boardRepository.findAll(pageable);
////		return page.getContent();
//		return (List<Notice>) noticeRepository.findAll();
//	}
//
//	// id값으로 삭제
//	@Override
//	public void deleteId(Long id) {
//		noticeRepository.deleteByNoticeId(id);
//	}
//
//	@Override // id값으로 한건 조회
//	public Notice oneSelectView(Long noticeId) {
//		return noticeRepository.findByNoticeId(noticeId).orElse(null);
//	}
//
//	@Override // id값으로 한건 조회 시 조회수 카운트
//	public void visit(Long noticeId) {
//		Notice notice = noticeRepository.findByNoticeId(noticeId).orElse(null);
//		if (notice != null) {
//			notice.setViewcnt(notice.getViewcnt() + 1);
//			noticeRepository.save(notice);
//		}
//	}
}
