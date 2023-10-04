package com.resort.springboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resort.springboot.domain.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long>{

}
