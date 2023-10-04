package com.resort.springboot.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resort.springboot.domain.SiteUser;

@Repository
public interface UserRepository extends JpaRepository<SiteUser, Long> {

	SiteUser findByEmail(String email);

	Optional<SiteUser> findById(String id);

}
