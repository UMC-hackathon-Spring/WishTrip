package umc.spring2.convert;

import umc.spring2.domain.Member;
import umc.spring2.dto.MemberResponseDTO;

import java.util.Optional;

public class MemberConverter {

    public static MemberResponseDTO.MyNameDTO toMyNameDTO(Optional<Member> member) {
        return new MemberResponseDTO.MyNameDTO(member.getNickname());
    }
}
