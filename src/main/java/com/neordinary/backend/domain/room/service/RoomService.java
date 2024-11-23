package com.neordinary.backend.domain.room.service;

import com.neordinary.backend.domain.room.dto.RequestCreateRoom;
import com.neordinary.backend.domain.room.dto.StartRoomDto;
import com.neordinary.backend.domain.room.dto.RoomCodeDto;
import com.neordinary.backend.domain.user.domain.User;

public interface RoomService {

    RoomCodeDto create(User user, RequestCreateRoom requestCreateRoom);

    void join(User user, String code);
  
    StartRoomDto start(User user, String code);
  }