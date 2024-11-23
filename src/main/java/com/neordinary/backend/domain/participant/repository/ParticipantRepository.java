package com.neordinary.backend.domain.participant.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neordinary.backend.domain.participant.entity.Participant;

public interface ParticipantRepository extends JpaRepository<Participant,Long> {

	Optional<Participant> findByUserEmailAndRoomId(String email, Long roomId);

	List<Participant> findByRoomId(Long id);

    boolean existsByUserId(Long userId);
}