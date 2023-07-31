package kr.ac.kopo.ctc.kopo11.board.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.ctc.kopo11.board.domain.BoardComment;

@Repository
public interface ReBoardRepository extends JpaRepository<BoardComment,Long>{
	
}

