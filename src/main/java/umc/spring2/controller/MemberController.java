package umc.spring2.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring2.apiPayload.ApiResponse;
import umc.spring2.config.security.CustomUserDetailsService;
import umc.spring2.convert.MemberConverter;
import umc.spring2.domain.Member;
import umc.spring2.dto.MemberRequestDTO;
import umc.spring2.dto.MemberResponseDTO;
import umc.spring2.service.MemberService;
import umc.spring2.service.ResetService;

import java.util.Optional;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;
    private final ResetService resetService;

    @GetMapping("/{memberId}/my_name")
    @Operation(summary = "내 이름(사용자 ID) 조회 API", description = "현재 로그인한 사용자의 이름을 조회합니다.")
    public ApiResponse<MemberResponseDTO.MyNameDTO> getMyName(@PathVariable(value = "memberId") Long memberId) {
        Member member = memberService.getMemberById(memberId);
        return ApiResponse.onSuccess(MemberConverter.toMyNameDTO(member));
    }

    @PostMapping("/signup")
    @Operation(summary = "유저 회원가입 API",description = "유저가 회원가입 API입니다.")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> signup(@RequestBody @Valid MemberRequestDTO.JoinDto request){
        Member member = memberService.signupMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }

    @PostMapping("/login")
    @Operation(summary = "유저 로그인 API",description = "유저가 로그인 API입니다.")
    public ApiResponse<MemberResponseDTO.LoginResultDTO> login(@RequestBody @Valid MemberRequestDTO.LoginRequestDTO request) {
        return ApiResponse.onSuccess(memberService.loginMember(request));
    }

    @PostMapping("/{memberId}/reset")
    @Operation(summary = "위시트립 초기화", description = "위시트립을 초기화합니다.")
    public ApiResponse<MemberResponseDTO.ResetDTO> reset(@PathParam(value = "memberId") String memberId) {
        return ApiResponse.onSuccess(resetService.resetData(memberId));
    }
}

