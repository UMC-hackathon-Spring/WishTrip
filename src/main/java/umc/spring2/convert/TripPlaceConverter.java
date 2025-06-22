package umc.spring2.convert;

import org.springframework.stereotype.Component;
import umc.spring2.domain.Member;
import umc.spring2.domain.TripPlace;
import umc.spring2.web.dto.TripPlaceRequestDTO;
import umc.spring2.web.dto.TripPlaceResponseDTO;

@Component
public class TripPlaceConverter {
    public TripPlace toEntity(TripPlaceRequestDTO dto, Member member) {
        return TripPlace.builder()
                .member(member)
                .country(dto.getCountry())
                .city(dto.getCity())
                .completed(dto.getCompleted())
                .imageUrl(dto.getImageUrl())
                .build();
    }

    public TripPlaceResponseDTO toResponseDTO(TripPlace entity) {
        return TripPlaceResponseDTO.builder()
                .id(entity.getId())
                .country(entity.getCountry())
                .city(entity.getCity())
                .completed(entity.getCompleted())
                .imageUrl(entity.getImageUrl())
                .build();
    }
}
