package com.neordinary.backend.domain.vote.repository;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.neordinary.backend.domain.vote.dto.VoteResponseDto;
import com.neordinary.backend.domain.vote.dto.VoteResultDto;
import com.neordinary.backend.domain.vote.entity.Vote;

public interface VoteRepository extends JpaRepository<Vote, Long> {
	@Query("SELECT new com.neordinary.backend.domain.vote.dto.VoteResultDto( " +
		"       q.id, " +
		"       r.name, " +
		"       q.prizeName, " +
		"       q.prizeContent, " +
		"       u.name, " +
		"       COUNT(v)) " +
		"FROM Vote v " +
		"JOIN v.question q " +
		"JOIN q.room r " +
		"JOIN v.voted.user u " +
		"WHERE q.id = :questionId " +
		"GROUP BY q.id, r.name, q.prizeName, q.prizeContent, u.name " +
		"ORDER BY COUNT(v) DESC "+
		"LIMIT 1")
	List<VoteResultDto> findTopVoteResultByQuestionId(@Param("questionId") Long questionId);


}
