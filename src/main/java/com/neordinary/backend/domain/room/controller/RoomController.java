package com.neordinary.backend.domain.room.controller;

import com.neordinary.backend.domain.room.dto.RequestCreateRoom;
import com.neordinary.backend.domain.room.dto.RoomCodeDto;
import com.neordinary.backend.domain.room.service.RoomService;
import com.neordinary.backend.domain.user.domain.User;
import com.neordinary.backend.global.jwt.CurrentUser;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/rooms")
@RequiredArgsConstructor
public class RoomController {

    private static final String JOIN_SUCCESS_MESSAGE = "방참가 성공";

    private final RoomService roomService;


    @PostMapping
    @Operation(summary = "방 생성", description = """
            # 방 생성
                        
            입력 값: 방이름, custom 질문["question_num": Int ,
                              "question_content": "string",
                              "prize_name": "string",
                              "prize_content": "string"] 
                        
            ## 응답
                        
            - 방 생성 완료 시 
                - 랜덤 생성된 방 고유 코드 반환 ex) 1234 
            """)
    @ApiResponse(
            responseCode = "200",
            description = "방 생성 성공",
            useReturnTypeSchema = true
    )
    @PreAuthorize("isAuthenticated()")
    @SecurityRequirement(name = "access-token")
    public RoomCodeDto create(@CurrentUser User user, @RequestBody final RequestCreateRoom requestCreateRoom) {
        return roomService.create(user, requestCreateRoom);
    }

    @PostMapping("/join")
    @Operation(summary = "방 참가", description = """
            # 방 참가
                        
            입력값: 방 코드 ex) 1234
                        
            ## 응답
                        
            - 방 참가 완료시 "방 참가 성공" 반환
            """)
    @ApiResponse(
            responseCode = "200",
            description = "방 참가 성공",
            useReturnTypeSchema = true
    )
    @PreAuthorize("isAuthenticated()")
    @SecurityRequirement(name = "access-token")
    public void join(@CurrentUser User user, @RequestParam("code") String code){
        roomService.join(user, code);
    }
}