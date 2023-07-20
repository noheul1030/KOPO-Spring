package kr.ac.kopo.ctc.kopo11.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import kr.ac.kopo.ctc.kopo11.board.domain.Sample;
import kr.ac.kopo.ctc.kopo11.board.repo.SampleRepository;

@Service
public class SampleServiceImpl implements SampleService{
	
	@Autowired
	private SampleRepository sampleRepository;

	@Override
	public String testNoAop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String testAop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String testNoTransactional() {
		Sample sample = sampleRepository.findById(1L).get();
		sample.setTitle("update");
		sampleRepository.save(sample);
		
		throw new RuntimeException("Spring Boot No Transactional Test");
	}

	@Override
	@Transactional
	public String testTransactional() {
		Sample sample = sampleRepository.findById(1L).get();
		sample.setTitle("update");
		sampleRepository.save(sample);
		
		throw new RuntimeException("Spring Boot No Transactional Test");
	}
}
