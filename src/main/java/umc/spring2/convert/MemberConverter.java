package umc.spring2.convert;

import umc.spring2.domain.Member;
import umc.spring2.dto.MemberResponseDTO;
import umc.spring2.dto.MemberRequestDTO;
import java.util.Optional;

import java.time.LocalDateTime;
import java.util.ArrayList;


public class MemberConverter {

    public static MemberResponseDTO.MyNameDTO toMyNameDTO(Member member) {
        return new MemberResponseDTO.MyNameDTO(member.getNickname());
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
                .loginId(request.getUser_id())
                .loginPwd(request.getUser_pwd())
                .phone(request.getPhone_num())
                .nickname(request.getNickname())
                .build();
    }
}
