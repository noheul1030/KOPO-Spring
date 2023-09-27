package com.resort.springboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resort.springboot.domain.RoomReservationItem;

@Repository
public interface RoomReservationRepository extends JpaRepository<RoomReservationItem,Long>{

}
