package com.resort.springboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resort.springboot.domain.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer>{
}
