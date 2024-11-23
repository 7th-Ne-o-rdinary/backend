package com.neordinary.backend.domain.room.controller;

import com.neordinary.backend.domain.room.dto.RequestCreateRoom;
import com.neordinary.backend.domain.room.service.RoomService;
import com.neordinary.backend.domain.user.domain.User;
import com.neordinary.backend.global.jwt.CurrentUser;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/rooms")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @PostMapping
    public String create(@CurrentUser User user, @RequestBody final RequestCreateRoom requestCreateRoom) {
        return roomService.create(user, requestCreateRoom);
    }
}