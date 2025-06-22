package umc.spring2.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring2.apiPayload.code.status.ErrorStatus;
import umc.spring2.apiPayload.exception.GeneralException;
import umc.spring2.domain.Member;
import umc.spring2.domain.TripRecord;
import umc.spring2.web.dto.MemberResponseDTO;
import umc.spring2.repository.MemberRepository;
import umc.spring2.repository.TripRecordRepository;

@Service
@RequiredArgsConstructor
public class ResetService {

    private final MemberRepository memberRepository;
    private final TripRecordRepository tripRecordRepository;

    @Transactional
    public MemberResponseDTO.ResetDTO resetData(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new GeneralException(ErrorStatus.MEMBER_NOT_FOUND));

        for (TripRecord tripRecord : tripRecordRepository.findByMemberId(memberId)) {
            tripRecordRepository.deleteById(tripRecord.getId());
        }
        return MemberResponseDTO.ResetDTO.builder().memberId(memberId).build();
    }
}
