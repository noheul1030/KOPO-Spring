package kr.ac.kopo.ctc.kopo11.board.repo;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.ctc.kopo11.board.domain.Sample;

@Repository
public interface UserRepository extends JpaRepository<Sample, Long>,JpaSpecificationExecutor<Sample>{
	Optional<Sample> findOneBytitle(String title);
	   
	   Page<Sample> findAllById(Long id, Pageable pageable);
	   
	   List<Sample> findAllById(Long id);

	   Page<Sample> findAll(Pageable pageable);
}