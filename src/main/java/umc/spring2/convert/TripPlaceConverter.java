package umc.spring2.convert;

import org.springframework.stereotype.Component;
import umc.spring2.domain.TripPlace;
import umc.spring2.web.dto.TripPlaceRequestDTO;
import umc.spring2.web.dto.TripPlaceResponseDTO;

@Component
public class TripPlaceConverter {
    public TripPlace toEntity(TripPlaceRequestDTO dto, User user) {
        return TripPlace.builder()
                .member(Member.getId())
                .country(TripPlace.getCountry())
                .city(dto.getCity())
                .completed(dto.getCompleted())
                .imageUrl(dto.getImageUrl())
                .build();
    }

    public TripPlaceResponseDTO toResponseDTO(TripPlace tripPlace) {
        return TripPlaceResponseDTO.builder()
                .id(tripPlace.getId())
                .country(tripPlace.getCountry())
                .city(tripPlace.getCity())
                .completed(tripPlace.getCompleted())
                .imageUrl(tripPlace.getImageUrl())
                .build();
    }
}
