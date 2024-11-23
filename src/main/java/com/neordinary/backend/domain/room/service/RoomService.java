package com.neordinary.backend.domain.room.service;

import com.neordinary.backend.domain.room.dto.RequestCreateRoom;
import com.neordinary.backend.domain.user.domain.User;

public interface RoomService {
    String create(User user, RequestCreateRoom requestCreateRoom);

    void join(User user, String code);
}
