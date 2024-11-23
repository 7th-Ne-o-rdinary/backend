package com.neordinary.backend.domain.vote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neordinary.backend.domain.vote.entity.Vote;

public interface VoteRepository extends JpaRepository<Vote, Long> {

}
