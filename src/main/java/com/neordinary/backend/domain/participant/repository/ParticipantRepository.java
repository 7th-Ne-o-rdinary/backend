package com.neordinary.backend.domain.participant.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neordinary.backend.domain.participant.entity.Participant;

public interface ParticipantRepository extends JpaRepository<Participant,Long> {

	Optional<Participant> findByUserEmail(String email);
}
