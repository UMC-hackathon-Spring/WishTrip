package umc.spring2.service.Trip;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring2.apiPayload.code.status.ErrorStatus;
import umc.spring2.apiPayload.exception.GeneralException;
import umc.spring2.domain.Member;
import umc.spring2.domain.TripPlace;
import umc.spring2.repository.MemberRepository;
import umc.spring2.repository.TripPlaceRepository;
import umc.spring2.web.dto.TripPlaceRequestDTO;

@Service
@RequiredArgsConstructor
public class TripPlaceCommandServiceImpl implements TripPlaceCommandService {

    private final TripPlaceRepository tripPlaceRepository;
    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public TripPlace createTripPlace(TripPlaceRequestDTO request) {
        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new GeneralException(ErrorStatus.MEMBER_NOT_FOUND));

        TripPlace place = TripPlace.builder()
                .member(member)
                .country(request.getCountry())
                .city(request.getCity())
                .imageUrl(request.getImageUrl())
                .completed(false) // 기본값은 여행x상태 false
                .build();

        return tripPlaceRepository.save(place);
    }
}