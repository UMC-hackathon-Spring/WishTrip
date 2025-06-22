package umc.spring2.service.Trip;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring2.apiPayload.code.status.ErrorStatus;
import umc.spring2.apiPayload.exception.GeneralException;
import umc.spring2.domain.TripPlace;
import umc.spring2.repository.MemberRepository;
import umc.spring2.repository.TripPlaceRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TripPlaceQueryServiceImpl implements TripPlaceQueryService {

    private final TripPlaceRepository tripPlaceRepository;
    private final MemberRepository memberRepository;

    @Override
    public List<TripPlace> getTripPlacesWithRecord(Long memberId) {
        if (!memberRepository.existsById(memberId)) {
            throw new GeneralException(ErrorStatus.MEMBER_NOT_FOUND);
        }

        return tripPlaceRepository.findAllWithTripRecordByMemberId(memberId);
    }

    @Override
    @Transactional
    public String completeTripPlace(Long placeId, Long memberId) {
        TripPlace tripPlace = tripPlaceRepository.findById(placeId)
                .orElseThrow(() -> new GeneralException(ErrorStatus.TRIP_PLACE_NOT_EXIST));

        if (!tripPlace.getMember().getId().equals(memberId)) {
            throw new RuntimeException("권한 없음");
        }

        tripPlace.setCompleted(true);
        return "complete";
    }
}