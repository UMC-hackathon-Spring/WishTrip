package umc.spring2.convert;

import umc.spring2.domain.Member;
import umc.spring2.dto.MemberResponseDTO;

public class MemberConverter {

    public static MemberResponseDTO.MyNameDTO toUserNameDTO(Member member) {
        return new MemberResponseDTO.MyNameDTO(member);
    }
}
