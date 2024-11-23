package com.neordinary.backend.domain.room.repository;

import com.neordinary.backend.domain.room.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}