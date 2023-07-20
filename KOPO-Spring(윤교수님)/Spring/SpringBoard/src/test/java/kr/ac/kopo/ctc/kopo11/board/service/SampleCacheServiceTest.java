package kr.ac.kopo.ctc.kopo11.board.service;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SampleCacheServiceTest {
	
	private static final Logger logger = LoggerFactory.getLogger(SampleCacheServiceTest.class);
	
	@Autowired
	private SampleCacheService sampleCacheService;
	
	private long startTime;
	private long endTime;
	
	@Before
	public void onBefore() {
		startTime = System.currentTimeMillis();
	}
	
	@After
	public void onAfter() {
		endTime = System.currentTimeMillis();
		logger.info("소요시간: {}ms, endTime - startTime");
	}
	
	@Test
	void testNoCache() {
		sampleCacheService.testNoCache(1L);
	}

	@Test
	void testCache1() {
		sampleCacheService.testCache(1L);
	}
	@Test
	void testCache2() {
		sampleCacheService.testCache(1L);
	}
	@Test
	void testCache3() {
		sampleCacheService.testCache(2L);
	}
	@Test
	void testCache4() {
		sampleCacheService.testCache(1L);
	}
	@Test
	void testCache5() {
		sampleCacheService.testCacheClear(1L);
		sampleCacheService.testCache(1L);
	}

}
