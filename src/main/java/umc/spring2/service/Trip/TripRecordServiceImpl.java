package umc.spring2.service.Trip;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring2.domain.Member;
import umc.spring2.domain.TripPlace;
import umc.spring2.domain.TripRecord;
import umc.spring2.repository.MemberRepository;
import umc.spring2.repository.TripPlaceRepository;
import umc.spring2.repository.TripRecordRepository;
import umc.spring2.web.dto.TripRecordRequestDTO;
import umc.spring2.web.dto.TripRecordResponseDTO;
import umc.spring2.convert.TripRecordConverter;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TripRecordServiceImpl implements TripRecordService{
    private final TripRecordRepository tripRecordRepository;
    private final TripPlaceRepository tripPlaceRepository;
    private final MemberRepository memberRepository;
    private final TripRecordConverter tripRecordConverter;

    @Override
    public List<TripPlace>

    @Override
    @Transactional
    public TripRecordResponseDTO createTripRecord(TripRecordRequestDTO dto) {
        Member member = memberRepository.findById(dto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자입니다."));

        TripPlace place = tripPlaceRepository.findById(dto.getPlaceId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 여행지입니다."));

        TripRecord tripRecord = tripRecordConverter.toEntity(dto, member, place);
        TripRecord saved = tripRecordRepository.save(tripRecord);

        return tripRecordConverter.toResponseDTO(saved);
    }

    @Override
    public List<TripRecordResponseDTO> getTripRecordsByUser(Long userId) {
        List<TripRecord> records = tripRecordRepository.findByUserId(userId);
        return records.stream()
                .map(tripRecordConverter::toResponseDTO)
                .collect(Collectors.toList());
    }
}
