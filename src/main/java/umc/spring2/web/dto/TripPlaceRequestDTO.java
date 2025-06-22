package umc.spring2.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
public class TripPlaceRequestDTO {

    @NotNull
    private Long memberId;

    @NotNull
    private String country;

    @NotNull
    private String city;

    private String imageUrl;
}