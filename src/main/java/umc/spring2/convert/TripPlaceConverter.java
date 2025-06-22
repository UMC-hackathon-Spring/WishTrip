package umc.spring2.convert;

import umc.spring2.domain.TripPlace;
import umc.spring2.web.dto.TripPlaceResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

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

    public static TripPlaceResponseDTO.TripPlaceListDTO toTripPlaceListDTO(TripPlace tripPlace) {
        boolean hasRecord = tripPlace.getTripRecord() != null;

        return TripPlaceResponseDTO.TripPlaceListDTO.builder()
                .id(tripPlace.getId())
                .country(tripPlace.getCountry())
                .city(tripPlace.getCity())
                .completed(tripPlace.getCompleted())
                .hasRecord(hasRecord)
                .imageUrl(tripPlace.getImageUrl())
                .build();
    }


    public static List<TripPlaceResponseDTO.TripPlaceListDTO> toTripPlaceListDTOList(List<TripPlace> places) {
        return places.stream()
                .map(TripPlaceConverter::toTripPlaceListDTO)
                .collect(Collectors.toList());
    }
}