package com.neordinary.backend.domain.room.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neordinary.backend.domain.room.entity.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {
	Optional<Room> findById(Long id);
}

