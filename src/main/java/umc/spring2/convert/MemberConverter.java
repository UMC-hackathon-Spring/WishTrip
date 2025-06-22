package umc.spring2.convert;

import umc.spring2.domain.Member;
import umc.spring2.web.dto.MemberResponseDTO;
import umc.spring2.web.dto.MemberRequestDTO;

import java.time.LocalDateTime;


public class MemberConverter {

    public static MemberResponseDTO.MyNameDTO toMyNameDTO(Member member) {
        return MemberResponseDTO.MyNameDTO.builder()
                .nickname(member.getNickname())
                .build();
    }
    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member) {
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static MemberResponseDTO.LoginResultDTO toLoginResultDTO(Long memberId, String accessToken) {
        return MemberResponseDTO.LoginResultDTO.builder()
                .memberId(memberId)
                .accessToken(accessToken)
                .build();
    }

    public static Member toMember(MemberRequestDTO.JoinDto request) {
        return Member.builder()
                .loginId(request.getLoginId())
                .loginPwd(request.getLoginPwd())
                .phone(request.getPhone())
                .nickname(request.getNickname())
                .build();
    }
}
