package kr.ac.kopo.ctc.kopo11.board.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class BoardItemServiceTest {

	@Autowired
	private BoardItemService boardItemService;
	
	@Test
	void test() {
		boardItemService.test();
	}
	@Test
	void testAopBefore() {
		boardItemService.testAopBefore();
	}
	@Test
	void testAopAfter() {
		boardItemService.testAopAfter();
	}
	@Test
	void testAopAfterReturning() {
		boardItemService.testAopAfterReturning();
	}
	@Test
	void testAopAfterThrowing() {
		assertThrows(RuntimeException.class, () -> {
	         boardItemService.testAopAfterThrowing();
		});
	}
	@Test
	void testAopAround() {
		boardItemService.testAopAround();
	}
	
	
	
	@Test
	void testPointcutBefore() {
		boardItemService.testPointcutBefore();
	}
	@Test
	void testPointcutAfter() {
		boardItemService.testPointcutAfter();
	}
	@Test
	void testPointcutAfterReturning() {
		boardItemService.testPointcutAfterReturning();
	}
	@Test
	void testPointcutAfterThrowing() {		
		assertThrows(RuntimeException.class, () -> {
			boardItemService.testPointcutAfterThrowing();
		});
	}
	@Test
	void testPointcutAround() {
		boardItemService.testPointcutAround();
	}
}
