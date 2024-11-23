package com.neordinary.backend.domain.vote.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neordinary.backend.domain.user.domain.User;
import com.neordinary.backend.domain.vote.dto.VoteRequestDto;
import com.neordinary.backend.domain.vote.dto.VoteResponseDto;
import com.neordinary.backend.domain.vote.dto.VoteResultDto;
import com.neordinary.backend.domain.vote.service.VoteService;
import com.neordinary.backend.global.exception.ApiErrorResponse;
import com.neordinary.backend.global.jwt.CurrentUser;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/vote")
@RequiredArgsConstructor
public class VoteController {
	private final VoteService voteService;

	@PostMapping("/")
	@Operation(summary="투표 API", description = """
            # 투표 진행 API

            - votePeopleEmail에 투표하는 사람의 이메일 값
            - votedPeopleEmail에 투표받는 사람의 이메일 값
            - questionId에 질문의 ID값
            """)
	@ApiResponse(
		responseCode = "404",
		description = "결과값 없음",
		content = @Content(
			mediaType = MediaType.APPLICATION_JSON_VALUE,
			schema = @Schema(implementation = ApiErrorResponse.class),
			examples = @ExampleObject(value = """
                            {
                                "status": "NOT_FOUND",
                                "message": "투표 결과가 존재하지 않습니다."
                            }
                            """)
		)
	)
	@PreAuthorize("isAuthenticated()")
	@SecurityRequirement(name = "access-token")

	@ApiResponse(
		responseCode = "200",
		description = "투표 성공",
		useReturnTypeSchema = true
	)
	public ResponseEntity<VoteResponseDto.createVoteResultDto> createVote (@CurrentUser User user, @Valid @RequestBody VoteRequestDto.createVoteDto request){
		VoteResponseDto.createVoteResultDto createVoteResultDto = voteService.createVote(user, request);
		return ResponseEntity.ok(createVoteResultDto);
	}

	@GetMapping("/result/{questionId}")
	@Operation(summary="결과 조회 API", description = """
            # 투표 결과 조회 API

            - pathVariable로 questionId 값을 받음
            - 결과값으로 quesitionId, roomName(시상식 명),prizeName(상 이름), userName(유저 이름), prizeContent(시상 내용),voteCount(투표 수)
            """)
	@ApiResponse(
		responseCode = "200",
		description = "투표 결과 조회 성공",
		useReturnTypeSchema = true
	)
	@ApiResponse(
			responseCode = "400",
			description = "아직 투표가 진행중입니다.",
			content = @Content(
					mediaType = MediaType.APPLICATION_JSON_VALUE,
					schema = @Schema(implementation = ApiErrorResponse.class),
					examples = @ExampleObject(value = """
							{
								"status": "BAD_REQUEST",
								"message": "투표가 종료되지 않았습니다."
							}
							""")
			)
	)
	@ApiResponse(
		responseCode = "404",
		description = "존재하지 않는 참가자입니다.",
		content = @Content(
			mediaType = MediaType.APPLICATION_JSON_VALUE,
			schema = @Schema(implementation = ApiErrorResponse.class),
			examples = @ExampleObject(value = """
                            {
                                "status": "BAD_REQUEST",
                                "message": "존재하지 않는 참가자입니다."
                            }
                            """)
		)
	)
	public ResponseEntity<List<VoteResultDto>> voteResult (@PathVariable(name="questionId") Long questionId){
		List<VoteResultDto> voteResultDto= voteService.getVoteResult(questionId);
		return ResponseEntity.ok(voteResultDto);
	}

}