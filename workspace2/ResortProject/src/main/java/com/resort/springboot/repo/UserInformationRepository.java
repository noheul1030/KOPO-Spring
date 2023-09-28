package com.resort.springboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resort.springboot.domain.UserInformationItem;

@Repository
public interface UserInformationRepository extends JpaRepository<UserInformationItem,Long>{

	UserInformationItem findByEmail(String email);

}
