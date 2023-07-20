package kr.ac.kopo.ctc.kopo11.board.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SampleServiceTest {

	@Autowired
	private SampleService sampleService;

	//@Disabled
	@Test
	public void testNoTransactional() {

		assertThrows(RuntimeException.class, () -> {
			sampleService.testNoTransactional();
		});
	}

	@Test
	public void testTransactional() {
		assertThrows(RuntimeException.class, () -> {
			sampleService.testTransactional();
		});

	}

}
