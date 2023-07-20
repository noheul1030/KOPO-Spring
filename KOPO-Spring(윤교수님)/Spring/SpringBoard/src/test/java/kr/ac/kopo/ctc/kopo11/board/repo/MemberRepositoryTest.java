package kr.ac.kopo.ctc.kopo11.board.repo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import jakarta.transaction.Transactional;
import kr.ac.kopo.ctc.kopo11.board.domain.Member;
import kr.ac.kopo.ctc.kopo11.board.domain.Phone;

@RunWith(SpringRunner.class)
@SpringBootTest
class MemberRepositoryTest {

	@Autowired
	private MemberRepository memberRepository;
	
	@Test
	public void oneToMany_TwoWay() {
		Member first = new Member("Jung",20);
		first.addPhone(new Phone("010-1111-1111"));
		first.addPhone(new Phone("010-2222-2222"));
		
		Member second = new Member("Dong",25);
		second.addPhone(new Phone("010-3333-3333"));
		
		Member third = new Member("Min",35);
		third.addPhone(new Phone("010-4444-4444"));
		
		Member fourth = new Member("Noeul",33);
		fourth.addPhone(new Phone("010-5555-5555"));
		
		memberRepository.save(first);
		memberRepository.save(second);
		memberRepository.save(third);
		memberRepository.save(fourth);		
		
		//memberRepository.deleteAll();
	}
	
	
	   //Create
	   @Test
	   public void create() {
	      Member one = new Member("Test",22);
	      one.addPhone(new Phone("010-####-####"));
	      one.addPhone(new Phone("010-****-****"));
	      memberRepository.save(one);
	   }
	   
	   
	   //Read
	   @Test
	   @Transactional
	   public void readAll() {
	      List<Member> list = memberRepository.findAll();
	      
	      for(Member m : list) {
	         System.out.println(m.toString());
	      }
	   }	   
	   
	   
	   // UPDATE
	   @Test
	   public void update() {
	      Member member = memberRepository.findById(103);
	      member.setAge(10);
	      member.setName("AAA");
	      memberRepository.save(member);
	   }
	   
	   
	   //Delete
	   @Test
	   public void deleteAll() {
	       memberRepository.deleteAll();
	   }
	   
	   //Delete
	   @Test
	   public void delete() {
		    Member member = memberRepository.findById(105);
		    memberRepository.deleteById(member.getId());
	   }
}
