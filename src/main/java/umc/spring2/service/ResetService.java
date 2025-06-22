package umc.spring2.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring2.dto.MemberResponseDTO;
import umc.spring2.repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class ResetService {
    private final MemberRepository memberRepository;

    public MemberResponseDTO.ResetDTO resetData(String memberId) {

        return MemberResponseDTO.ResetDTO.builder().memberId(memberId).build();
    }
}
