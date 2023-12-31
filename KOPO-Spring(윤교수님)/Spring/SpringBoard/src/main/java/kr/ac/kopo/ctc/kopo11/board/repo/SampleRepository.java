package kr.ac.kopo.ctc.kopo11.board.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.ctc.kopo11.board.domain.Sample;

@Repository
public interface SampleRepository extends JpaRepository<Sample, Long>{

}
