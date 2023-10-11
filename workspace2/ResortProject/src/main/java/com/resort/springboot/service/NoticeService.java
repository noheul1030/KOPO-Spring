package com.resort.springboot.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.resort.springboot.domain.Notice;
import com.resort.springboot.domain.SiteUser;
import com.resort.springboot.exception.DataNotFoundException;
import com.resort.springboot.repo.NoticeRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional
@Service
public class NoticeService {

	private final NoticeRepository noticeRepository;
	
	public Notice getNotice(long noticeId) {
		Optional<Notice> notice = this.noticeRepository.findById(noticeId);
		if (notice.isPresent()) {
			return notice.get();
		} else {
			throw new DataNotFoundException("post not found");
		}
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/* CREATE */
	// 1. New 게시글 등록
	public void newInsert(String title, String content, SiteUser user) {

		Notice notices = new Notice();

		// 현재 날짜를 LocalDateTime 객체로 가져오기

		notices.setId(user);
		notices.setTitle(title);
		notices.setContent(content);
		notices.setDate(LocalDateTime.now());
		notices.setViewcnt(0);
		this.noticeRepository.save(notices);

	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/* UPDATE */
	// 2. update
	public void update(Notice notice) {
		Notice notice2 = noticeRepository.findByNoticeId(notice.getNoticeId()).get();
		// 가져온 글에 수정한 내용을 세팅한다.
		notice2.setTitle(notice.getTitle());
		notice2.setContent(notice.getContent());
		notice2.setPostModifiedDate(LocalDateTime.now());

        // DB에 저장
		noticeRepository.save(notice2);
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/* READ */
	// 3. list
	public Page<Notice> getList(int page) {
		List<Sort.Order> sorts = new ArrayList<>();
		sorts.add(Sort.Order.desc("noticeId"));
		PageRequest pageable = PageRequest.of(page, 10, Sort.by(sorts)); // 페이지 번호 0부터 시작
		return this.noticeRepository.findAll(pageable);
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/* DELETE */
	// 4. delete
	public void deleteId(Long noticeId) {
		this.noticeRepository.deleteByNoticeId(noticeId);
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// 5. detail
	public Notice oneSelectView(Long noticeId) {
		return this.noticeRepository.findByNoticeId(noticeId).orElse(null);
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// 6. 조회수 카운트
	public void visit(Long noticeId) {
		Notice notice = noticeRepository.findByNoticeId(noticeId).orElse(null);
		if (notice != null) {
			notice.setViewcnt(notice.getViewcnt() + 1);
			noticeRepository.save(notice);
		}
	}

	// 7. 아이디 한건 조회
	public Notice getNotice(Long noticeId) {
		Optional<Notice> notice = this.noticeRepository.findByNoticeId(noticeId);
		if (notice.isPresent()) {
			return notice.get();
		} else {
			throw new DataNotFoundException("question not found");
		}
	}

}
