//package kr.ac.kopo.ctc.kopo11.board.repo;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//
//@SpringBootTest
//public class SampleRepositoryTest {
//
//	@Autowired
//	private SampleRepository sampleRepository;
//	
//	@Before
//	public void before() {
//		System.out.println("before");
//	}
//	@After
//	public void after() {
//		System.out.println("after");
//	}
//	@Test
//	public void findAll() {
//		assertEquals(10, sampleRepository.count());
//	}
//	@Test
//	public void equalTest() {
//		assertEquals("a","a");
//	}
//	@Test
//	@Disabled
//	public void notEqualTest() {
//		assertEquals("a","b");
//	}
//}
