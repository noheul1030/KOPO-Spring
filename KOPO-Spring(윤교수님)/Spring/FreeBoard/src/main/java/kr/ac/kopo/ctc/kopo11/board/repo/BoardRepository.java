package kr.ac.kopo.ctc.kopo11.board.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.ctc.kopo11.board.domain.BoardItem;


// JPA(DAO와 같은 방식 Mapper(Board.xml에 내가 코드짜야함)로 구현할지 JPA(기존에 내장된 함수 사용)로 구현할지 선택)

@Repository
public interface BoardRepository extends JpaRepository<BoardItem,Long>{

	
	@Query("SELECT MAX(b.id) + 1 FROM BoardItem b")
    Integer findNextAutoId();
	
	
	
}
