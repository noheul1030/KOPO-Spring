package com.resort.springboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resort.springboot.domain.ResortNoticeItem;

@Repository
public interface ResortNoticeRepository extends JpaRepository<ResortNoticeItem,Long>{

}