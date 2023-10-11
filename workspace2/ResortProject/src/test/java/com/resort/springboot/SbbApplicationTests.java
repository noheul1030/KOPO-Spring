package com.resort.springboot;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.resort.springboot.domain.Notice;
import com.resort.springboot.domain.SiteUser;
import com.resort.springboot.repo.NoticeRepository;

@SpringBootTest
class SbbApplicationTests {

	@Autowired
	private  NoticeRepository noticeRepository;
	
    @Test
    void newInsert(String title, String content, SiteUser user) {
        for (int i = 1; i <= 300; i++) {
        	user.setId("admin");
            title = String.format("테스트 데이터입니다:[%03d]", i);
            content = "내용무";
            Notice notices = new Notice();

    		// 현재 날짜를 LocalDateTime 객체로 가져오기

    		notices.setId(user);
    		notices.setTitle(title);
    		notices.setContent(content);
    		notices.setDate(LocalDateTime.now());
    		notices.setViewcnt(0);
    		
    		this.noticeRepository.save(notices);
        }
    }
}