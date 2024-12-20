package com.neordinary.backend.domain.question.entity;

import com.neordinary.backend.domain.room.entity.Room;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access= AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, columnDefinition = "TEXT")
	private String questionContent;

	@Column(nullable = false)
	private Integer questionNum;

	@Column(nullable = false)
	private String prizeName;

	@Column(nullable = false)
	private String prizeContent;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="room_id")
	private Room room;


    public void setRoom(Room room) {
		this.room = room;
    }

}
