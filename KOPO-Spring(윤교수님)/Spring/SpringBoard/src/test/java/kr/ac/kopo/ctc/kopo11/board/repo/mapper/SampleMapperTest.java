package kr.ac.kopo.ctc.kopo11.board.repo.mapper;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kr.ac.kopo.ctc.kopo11.board.domain.Sample;

@SpringBootTest
public class SampleMapperTest {

	private static final Logger logger = (Logger) LoggerFactory.getLogger(SampleMapperTest.class);
	
	@Autowired
	SampleMapper userMapper;
	
	
	@Test
	public void findAll() {
		List<Sample> samples = userMapper.findAll();
		for (Sample sample : samples) {
			logger.info(sample.getName());
		}
	}

}
