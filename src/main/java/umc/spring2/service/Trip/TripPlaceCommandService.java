package umc.spring2.service.Trip;

import umc.spring2.domain.TripPlace;
import umc.spring2.web.dto.TripPlaceRequestDTO;

public interface TripPlaceCommandService {
    TripPlace createTripPlace(TripPlaceRequestDTO request);
}