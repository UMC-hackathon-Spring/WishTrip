package umc.spring2.web.dto;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
public class TripPlaceResponseDTO {

    private Long tripPlaceId;
    private String country;
    private String city;
    private Boolean completed;
    private String imageUrl;

    @Getter
    @Builder
    @AllArgsConstructor
    public static class TripPlaceListDTO {
        private Long id;
        private String country;
        private String city;
        private Boolean completed;
        private boolean hasRecord;
        private String imageUrl;
    }
}