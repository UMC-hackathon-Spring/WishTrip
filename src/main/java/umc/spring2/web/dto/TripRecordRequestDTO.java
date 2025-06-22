package umc.spring2.web.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class TripRecordRequestDTO {
    private Long memberId;
    private Long placeId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String content;
}
