package com.security.test.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.security.test.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByEmail(String email);
}