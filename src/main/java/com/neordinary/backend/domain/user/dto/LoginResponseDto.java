package com.neordinary.backend.domain.user.dto;

import com.neordinary.backend.global.jwt.dto.TokenDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginResponseDto {
    UserInfoDto user;
    TokenDto token;
}