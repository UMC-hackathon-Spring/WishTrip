package umc.spring2.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring2.domain.Member;
import umc.spring2.domain.TripRecord;
import umc.spring2.dto.MemberResponseDTO;
import umc.spring2.repository.MemberRepository;
import umc.spring2.repository.TripRecordRepository;

@Service
@RequiredArgsConstructor
public class ResetService {

    private final MemberRepository memberRepository;
    private final TripRecordRepository tripRecordRepository;

    @Transactional
    public MemberResponseDTO.ResetDTO resetData(String loginId) {
        Member member = memberRepository.findByLoginId(loginId).orElseThrow();
        Long memberId = member.getId();
        for (TripRecord tripRecord : tripRecordRepository.findByMemberId(memberId)) {
            tripRecordRepository.deleteById(tripRecord.getTripRecordId());
        }
        return MemberResponseDTO.ResetDTO.builder().memberId(loginId).build();
    }
}
