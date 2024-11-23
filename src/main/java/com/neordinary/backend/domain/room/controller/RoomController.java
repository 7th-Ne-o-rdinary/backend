package com.neordinary.backend.domain.room.controller;

import com.neordinary.backend.domain.room.dto.RequestCreateRoom;
import com.neordinary.backend.domain.room.service.RoomService;
import com.neordinary.backend.domain.user.domain.User;
import com.neordinary.backend.global.jwt.CurrentUser;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/rooms")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @PostMapping
    @PreAuthorize("isAuthenticated()")
    @SecurityRequirement(name = "access-token")
    public String create(@CurrentUser User user, @RequestBody final RequestCreateRoom requestCreateRoom) {
        return roomService.create(user, requestCreateRoom);
    }
}