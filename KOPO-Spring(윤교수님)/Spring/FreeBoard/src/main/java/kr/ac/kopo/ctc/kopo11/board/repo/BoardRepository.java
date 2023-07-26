package kr.ac.kopo.ctc.kopo11.board.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import kr.ac.kopo.ctc.kopo11.board.domain.BoardItem;


// JPA(DAO와 같은 방식 Mapper(Board.xml에 내가 코드짜야함)로 구현할지 JPA(기존에 내장된 함수 사용)로 구현할지 선택)

@Repository
public interface BoardRepository extends JpaRepository<BoardItem,Integer>{
	
//	// 전체 게시글 조회
//	@Query("SELECT id,title,date,viewcnt FROM BoardItem b ORDER BY b.id DESC")
//	Page<BoardItem> findByIdAndTitleAndViewcntAndDate(PageRequest pageable);
//	
//	// id값으로 전체 조회
//    @Query("SELECT a FROM BoardItem a WHERE a.id = :id")
//    BoardItem oneSelectView(@Param("id") Integer id);
//    
//    // 조회수 증가하는 메서드 추가
//    @Transactional
//    @Modifying
//    @Query("UPDATE BoardItem a SET a.viewcnt = a.viewcnt + 1 WHERE a.id = :id")
//    void increaseViewCount(@Param("id") Integer id);
	
    
	
    
}
