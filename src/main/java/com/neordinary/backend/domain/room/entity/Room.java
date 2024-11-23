package com.neordinary.backend.room.entity;


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

	//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
	//    @JoinColumn(name = "user_id")
	//    private User user;

	public void setCode(String code) {
		this.code = code;
	}
}
