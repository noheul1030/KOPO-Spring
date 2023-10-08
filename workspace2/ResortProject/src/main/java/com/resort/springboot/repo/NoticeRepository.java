package com.resort.springboot.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resort.springboot.domain.Notice;

@Repository
public interface NoticeRepository extends JpaRepository<Notice,Long>{

	Optional<Notice> findByNoticeId(Long noticeId);

	void deleteByNoticeId(Long noticeId);
	
	// 회원 목록 + 검색
//	Page<Notice> findAll(Pageable pageable);
//
//	Page<Notice> findByTitleContainingIgnoreCase(String title, Pageable pageable);
		

}
