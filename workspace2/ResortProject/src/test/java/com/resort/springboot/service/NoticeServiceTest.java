package com.resort.springboot.service;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.resort.springboot.domain.Notice;
import com.resort.springboot.domain.SiteUser;
import com.resort.springboot.repo.NoticeRepository;

@SpringBootTest
class NoticeServiceTest {

	@Autowired
	private NoticeRepository noticeRepository;

	@Test
	void newInsertTest() {
		for (int i = 1; i <= 300; i++) {
			SiteUser user = new SiteUser();
			user.setId("admin");
			String title = String.format("테스트 데이터입니다:[%03d]", i);
			String content = "내용무";

			Notice notices = new Notice();

			notices.setContent(content);
			notices.setDate(LocalDateTime.now());
			notices.setId(user);
			notices.setPostModifiedDate(null);
			notices.setTitle(title);
			notices.setViewcnt(0);

			this.noticeRepository.save(notices);
		}
	}
}