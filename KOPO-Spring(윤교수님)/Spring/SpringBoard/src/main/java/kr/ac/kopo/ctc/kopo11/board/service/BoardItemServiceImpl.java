package kr.ac.kopo.ctc.kopo11.board.service;

import org.springframework.stereotype.Service;

@Service
public class BoardItemServiceImpl implements BoardItemService{
	
	@Override
	public int add(int a, int b) {
		return a + b;
	}
	@Override
	public void test() {
		System.out.println("BoardItemServiceImpl.test() 메서드 호출");		
	}
	@Override
	public void testAopBefore() {
		System.out.println("BoardItemServiceImpl.textAopBefor() 메서드 호출");		
	}
	@Override
	public void testAopAfter() {
		System.out.println("BoardItemServiceImpl.TestAopAfter() 메서드 호출");		
	}
	@Override
	public String testAopAfterReturning() {
		System.out.println("BoardItemServiceImpl.TestAopAfterReturning() 메서드 호출");
		return "Success";
	}
	@Override
	public void testAopAfterThrowing() {
		System.out.println("BoardItemServiceImpl.testAopAfterThrowing() 메서드 호출");
		throw new RuntimeException("runtime exception 발생");		
	}
	@Override
	public void testAopAround() {
		System.out.println("BoardItemServiceImpl.testAopAround() 메서드 호출");
	}
	@Override
	public void testPointcutBefore() {
		System.out.println("BoardItemServiceImpl.testPointcutBefore() 메서드 호출");
	}
	@Override
	public void testPointcutAfter() {
		System.out.println("BoardItemServiceImpl.testPointcutAfter() 메서드 호출");
	}
	@Override
	public String testPointcutAfterReturning() {
		System.out.println("BoardItemServiceImpl.testpointcutAfterReturning() 메서드 호출");
		return "Success";
	}
	@Override
	public void testPointcutAfterThrowing() {
		System.out.println("BoardItemServiceImpl.testPointcutAfterThrowing() 메서드 호출");
		throw new RuntimeException("runtime exception 발생");
	}
	@Override
	public void testPointcutAround() {
		System.out.println("BoardItemServiceImpl.testPointcutAround() 메서드 호출");
	}
}

