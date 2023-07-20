package kr.ac.kopo.ctc.kopo11.board.service;

public interface BoardItemService {

	int add(int a, int b);
	
	
	
	void test();
	void testAopBefore();
	void testAopAfter();
	String testAopAfterReturning();
	void testAopAfterThrowing();
	void testAopAround();
	
	void testPointcutBefore();
	void testPointcutAfter();
	String testPointcutAfterReturning();
	void testPointcutAfterThrowing();
	void testPointcutAround();

}
