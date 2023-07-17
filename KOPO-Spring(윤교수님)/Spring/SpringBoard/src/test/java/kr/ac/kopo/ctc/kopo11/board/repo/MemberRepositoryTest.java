package kr.ac.kopo.ctc.kopo11.board.repo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import kr.ac.kopo.ctc.kopo11.board.domain.Member;
import kr.ac.kopo.ctc.kopo11.board.domain.Phone;

@RunWith(SpringRunner.class)
@SpringBootTest
class MemberRepositoryTest {

	@Autowired
	private MemberRepository memberRepository;
	
	@Test
	//@Transactional
	public void oneToMany_TwoWay() {
		Member first = new Member("Jung");
		first.addPhone(new Phone("010-1111-1111"));
		first.addPhone(new Phone("010-2222-2222"));
		
		Member second = new Member("Dong");
		second.addPhone(new Phone("010-3333-3333"));
		
		Member third = new Member("Min");
		third.addPhone(new Phone("010-4444-4444"));
		
		Member fourth = new Member("Noeul");
		fourth.addPhone(new Phone("010-5555-5555"));
		
		memberRepository.save(first);
		memberRepository.save(second);
		memberRepository.save(third);
		memberRepository.save(fourth);
		
		List<Member> list = memberRepository.findAll();
		
		for( Member m : list ) {
			System.out.println(m.toString());
		}
		memberRepository.deleteAll();
	}
}
