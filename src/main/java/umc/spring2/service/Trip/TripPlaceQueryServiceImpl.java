package umc.spring2.service.Trip;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
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
}