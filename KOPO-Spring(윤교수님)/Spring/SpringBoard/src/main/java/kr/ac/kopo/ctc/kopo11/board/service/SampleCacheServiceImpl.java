package kr.ac.kopo.ctc.kopo11.board.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


@Service
public class SampleCacheServiceImpl implements SampleCacheService{

	private static final Logger logger = LoggerFactory.getLogger(SampleCacheServiceImpl.class);
	
	@Override
	public String testNoCache(Long id) {
		String msg = "Hello, Spring Boot No Cache";
		logger.info(msg);
		sleep(3);
		return msg;
	}

	@Override
	@Cacheable(value="sample", key="#id")
	public String testCache(Long id) {
		String msg = "Hello, Spring Boot Yes Cache";
		logger.info(msg);
		sleep(3);
		return msg;
	}

	@Override
	@CacheEvict(value="sample", key="#id")
	public void testCacheClear(Long id) {
		logger.info("cache clear => " + id);		
	}
	
	private void sleep(int second) {
		try {
			Thread.sleep(second * 1000L);
		}catch(InterruptedException e) {
			throw new IllegalStateException();
		}
	}

}

