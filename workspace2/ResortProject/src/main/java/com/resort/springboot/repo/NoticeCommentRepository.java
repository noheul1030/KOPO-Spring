package com.resort.springboot.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resort.springboot.domain.Notice;
import com.resort.springboot.domain.NoticeComment;

@Repository
public interface NoticeCommentRepository extends JpaRepository<NoticeComment,Long>{
	
	List<NoticeComment> getCommentByRootIdOrderByCommentId(Notice notice);

}
