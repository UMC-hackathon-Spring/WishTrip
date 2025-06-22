package umc.spring2.web.dto;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TripPlaceResponseDTO {
    private Long id;
    private String country;
    private String city;
    private Boolean completed;
    private String imageUrl;
}
