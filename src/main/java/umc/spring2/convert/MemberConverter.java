package umc.spring2.convert;

import umc.spring2.domain.Member;
import umc.spring2.dto.MemberRequestDTO;
import umc.spring2.dto.MemberResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class MemberConverter {

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
                .memberId(request.getUser_id())
                .memberPassword(request.getUser_pwd())
                .phone(request.getPhone_num())
                .nickname(request.getNickname())
                .build();
    }
}
