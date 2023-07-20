package kr.ac.kopo.ctc.kopo11.board.repo;

import static org.junit.jupiter.api.Assertions.*;

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
class PhoneRepositoryTest {

	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	private PhoneRepository phoneRepository;
	
	   //Create
	   @Test
	   public void create() {
		  Member member = memberRepository.findById(156);
	      Phone phone = new Phone("010-8888-8888");
	      phone.setMember(member);
	      phoneRepository.save(phone);
	   }	   
	   
	   //Read
	   @Test
	   public void readAll() {
	      List<Phone> list = phoneRepository.findAll();
	      
	      for(Phone m : list) {
	         System.out.println(m.toString());
	      }
	   }	   
	   
	   
	   // UPDATE
	   @Test
	   public void update() {
		  Phone phone = phoneRepository.findById(158);
		  phone.setNo("010-9999-9999");
		  phoneRepository.save(phone);
	   }
	   
	   
	   //Delete
//	   @Test
//	   public void deleteAll() {
//		   phoneRepository.deleteAll();
//	   }
	   
	   //Delete
	   @Test
	   public void delete() {
		    phoneRepository.deleteById(202);
	   }

}
