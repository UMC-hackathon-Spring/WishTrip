package umc.spring2.convert;

import org.springframework.stereotype.Component;
import umc.spring2.domain.TripRecord;
import umc.spring2.web.dto.TripRecordRequestDTO;
import umc.spring2.web.dto.TripRecordResponseDTO;
import umc.spring2.domain.TripPlace;
import umc.spring2.domain.TripRecord;
import umc.spring2.domain.Member;

@Component
public class TripRecordConverter {
    public TripRecord toEntity(TripRecordRequestDTO dto, Member member, TripPlace tripPlace) {
        return TripRecord.builder()
                .member(member)
                .place(tripPlace)
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .content(dto.getContent())
                .build();
    }

    public TripRecordResponseDTO toResponseDTO(TripRecord entity) {
        return TripRecordResponseDTO.builder()
                .id(entity.getTripRecordId())
                .placeCity(entity.getPlace().getCity())      // 유저 이름
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .content(entity.getContent())
                .build();
    }
}
