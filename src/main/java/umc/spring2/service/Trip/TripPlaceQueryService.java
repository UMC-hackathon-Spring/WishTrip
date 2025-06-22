package umc.spring2.service.Trip;

import umc.spring2.domain.TripPlace;

import java.util.List;

public interface TripPlaceQueryService {
    List<TripPlace> getTripPlacesWithRecord(Long memberId);
}