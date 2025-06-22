package umc.spring2.web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TripPlaceResponseDTO {
    private Long id;
    private String country;
    private String city;
    private Boolean completed;
    private String imageUrl;
}
