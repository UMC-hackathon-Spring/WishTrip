package umc.spring2.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring2.apiPayload.ApiResponse;
import umc.spring2.convert.MemberConverter;
import umc.spring2.domain.Member;
import umc.spring2.dto.MemberRequestDTO;
import umc.spring2.dto.MemberResponseDTO;
import umc.spring2.service.MemberService;

import java.util.Optional;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/my_name")
    @Operation(summary = "내 이름(사용자 ID) 조회 API", description = "현재 로그인한 사용자의 아이디 또는 이름을 조회합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "access 토큰 만료됨"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "access 토큰이 이상함")
    })
    public ApiResponse<MemberResponseDTO.MyNameDTO> getMyName(@AuthenticationPrincipal UserDetails userDetails) {
        Long memberId = userDetails.getId(); // 서비스로부터 Member 조회
        Member member = memberService.getMemberById(memberId);

        return ApiResponse.onSuccess(MemberConverter.toMyNameDTO(member));
    }

    @PostMapping("/signup")
    @Operation(summary = "유저 회원가입 API", description = "유저가 회원가입 API")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> signup(@RequestBody @Valid MemberRequestDTO.JoinDto request) {
        Member member = memberService.signupMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }

    @PostMapping("/login")
    @Operation(summary = "유저 로그인 API", description = "유저가 로그인 API")
    public ApiResponse<MemberResponseDTO.LoginResultDTO> login(@RequestBody @Valid MemberRequestDTO.LoginRequestDTO request) {
        return ApiResponse.onSuccess(memberService.loginMember(request));
    }

}

