package kr.ac.kopo.ctc.kopo11.board.dao;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import kr.ac.kopo.ctc.kopo11.board.domain.Sample;
import kr.ac.kopo.ctc.kopo11.board.repo.UserRepository;
import kr.ac.kopo.ctc.kopo11.board.repo.UserSpecs;

@SpringBootTest
public class UserRepositoryTests {
	private UserRepository userRepository;
	
	@Test
	public void findAll() {
		Map<String, Object> filter = new HashMap<String, Object>();
		filter.put("title","a");
		
		PageRequest pageable = PageRequest.of(0,10);
		Page<Sample> page = userRepository.findAll(UserSpecs.search(filter),pageable);
		
		for(Sample u : page) {
			System.out.println(u.getTitle());
		}
	}

}
