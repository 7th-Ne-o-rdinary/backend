package com.neordinary.backend.domain.room.entity;


import java.util.ArrayList;
import java.util.List;

import com.neordinary.backend.domain.question.entity.Question;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String code;

	@Column(nullable = false)
	private String status;

	@OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
	private List<Question> questionsList = new ArrayList<>();


	//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
	//    @JoinColumn(name = "user_id")
	//    private User user;

	public void setCode(String code) {
		this.code = code;
	}
}
