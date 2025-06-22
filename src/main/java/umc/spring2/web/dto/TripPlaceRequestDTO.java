package umc.spring2.web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TripPlaceRequestDTO {
    private String country;
    private String city;
    private Boolean completed;
    private String imageUrl;
}
