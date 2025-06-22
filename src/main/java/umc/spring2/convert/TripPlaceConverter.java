package umc.spring2.convert;

import umc.spring2.domain.TripPlace;
import umc.spring2.web.dto.TripPlaceResponseDTO;

public class TripPlaceConverter {

    public static TripPlaceResponseDTO toTripPlaceResponseDTO(TripPlace place) {
        return TripPlaceResponseDTO.builder()
                .tripPlaceId(place.getId())
                .country(place.getCountry())
                .city(place.getCity())
                .completed(place.getCompleted())
                .imageUrl(place.getImageUrl())
                .build();
    }
}