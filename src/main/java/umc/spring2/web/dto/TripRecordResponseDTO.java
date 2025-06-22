package umc.spring2.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TripRecordResponseDTO {
    private Long id;
    private String placeCity;     // 여행지 도시
    private String memberName;      // 유저 이름
    private LocalDate startDate;
    private LocalDate endDate;
    private String content;
}
