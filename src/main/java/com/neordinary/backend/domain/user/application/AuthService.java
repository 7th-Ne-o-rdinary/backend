package com.neordinary.backend.domain.user.application;

import com.neordinary.backend.domain.user.dao.UserRepository;
import com.neordinary.backend.domain.user.domain.User;
import com.neordinary.backend.domain.user.dto.*;
import com.neordinary.backend.domain.user.exception.InvalidRefreshTokenException;
import com.neordinary.backend.domain.user.exception.LoginFailException;
import com.neordinary.backend.domain.user.exception.PasswordCheckNotMatchException;
import com.neordinary.backend.domain.user.exception.UserCreateValidationException;
import com.neordinary.backend.global.jwt.TokenService;
import com.neordinary.backend.global.jwt.dto.TokenDto;
import com.neordinary.backend.global.jwt.refreshtoken.RefreshToken;
import com.neordinary.backend.global.jwt.refreshtoken.RefreshTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class AuthService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final RefreshTokenRepository refreshTokenRepository;
    private final TokenService tokenService;

    @Transactional
    public LoginResponseDto login(LoginRequest loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(LoginFailException::new);

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new LoginFailException();
        }

        return LoginResponseDto.builder()
                .user(UserInfoDto.fromEntity(user))
                .token(tokenService.generateToken(user.getEmail()))
                .build();
    }

    @Transactional
    public UserInfoDto createUser(CreateUserRequest createUserRequest) {
        try {
            User createdUser = userRepository.save(
                    new User(createUserRequest, passwordEncoder.encode(createUserRequest.getPassword()))
            );

            return UserInfoDto.builder()
                    .email(createdUser.getEmail())
                    .name(createdUser.getName())
                    .userRole(createdUser.getUserRole())
                    .build();

        } catch (DataIntegrityViolationException e) {
            throw new UserCreateValidationException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Transactional
    public TokenDto reissue(ReissueRequest reissueRequest) {
        String email = tokenService.validateRefreshToken(reissueRequest.getRefreshToken());

        RefreshToken refreshToken = refreshTokenRepository.findByEmail(email)
                .orElseThrow(InvalidRefreshTokenException::new);

        if(!refreshToken.getToken().equals(reissueRequest.getRefreshToken())) {
            throw new InvalidRefreshTokenException();
        }

        return new TokenDto(
                tokenService.createAccessToken(email),
                refreshToken.getToken()
        );
    }

    @Transactional
    public void logout(User user) {
        refreshTokenRepository.deleteByEmail(user.getEmail());
    }
}