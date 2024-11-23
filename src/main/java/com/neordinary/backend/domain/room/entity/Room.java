package com.neordinary.backend.domain.room.entity;



import java.util.ArrayList;
import java.util.List;

import com.neordinary.backend.domain.question.entity.Question;



import com.neordinary.backend.domain.user.domain.User;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private User user;


	@OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
	private List<Question> questionsList = new ArrayList<>();


    public void setCode(String code) {
        this.code = code;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

