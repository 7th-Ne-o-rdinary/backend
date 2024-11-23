package com.neordinary.backend.domain.participant.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neordinary.backend.domain.participant.Entity.Participant;

public interface ParticipantRepository extends JpaRepository<Participant,Long> {
	@Override
	Optional<Participant> findById(Long participant_id);
}
