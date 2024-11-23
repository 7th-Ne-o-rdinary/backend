package com.neordinary.backend.domain.room.repository;


import java.util.Optional;

import com.neordinary.backend.domain.room.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Long> {
    Optional<Room> findByCode(String code);
}
