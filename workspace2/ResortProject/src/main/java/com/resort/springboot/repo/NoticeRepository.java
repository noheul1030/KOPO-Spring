package com.resort.springboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resort.springboot.domain.Notice;

@Repository
public interface NoticeRepository extends JpaRepository<Notice,Long>{

}
