package com.neordinary.backend.domain.participant.repository;

import com.neordinary.backend.domain.participant.entity.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
}
