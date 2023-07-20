package kr.ac.kopo.ctc.kopo11.board.repo;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.ctc.kopo11.board.domain.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer>{
	List<Member> findByNameAndAgeLessThan(String name, int age);
	
	@Query("select t from Member t where name=:name and age < :age")
	List<Member> findByNameAndAgeLessThanSQL(@Param("name")String name, @Param("age") int age);
	
	List<Member> findByNameAndAgeLessThanOrderByAgeDesc(String name, int age);
	
	Member findById(int id);
}
