package umc.spring2.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring2.apiPayload.ApiResponse;
import umc.spring2.convert.TripPlaceConverter;
import umc.spring2.domain.TripPlace;
import umc.spring2.service.Trip.TripPlaceCommandService;
import umc.spring2.service.Trip.TripPlaceQueryService;
import umc.spring2.web.dto.TripPlaceRequestDTO;
import umc.spring2.web.dto.TripPlaceResponseDTO;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/trip_places")
@Tag(name = "TripPlace", description = "여행지 관련 API")
public class TripPlaceController {

    private final TripPlaceCommandService tripPlaceCommandService;
    private final TripPlaceQueryService tripPlaceQueryService;

    @PostMapping
    @Operation(summary = "여행지 생성 API", description = "새로운 여행지를 등록합니다.")
    public ApiResponse<TripPlaceResponseDTO> createTripPlace(@RequestBody TripPlaceRequestDTO request) {
        TripPlace tripPlace = tripPlaceCommandService.createTripPlace(request);
        return ApiResponse.onSuccess(TripPlaceConverter.toTripPlaceResponseDTO(tripPlace));
    }

    @GetMapping("/{memberId}")
    @Operation(summary = "여행지 목록 조회 API", description = "해당 사용자의 여행지 목록을 반환합니다.")
    public ApiResponse<List<TripPlaceResponseDTO.TripPlaceListDTO>> getTripPlaceList(@PathVariable Long memberId) {
        List<TripPlace> tripPlaces = tripPlaceQueryService.getTripPlacesWithRecord(memberId);
        return ApiResponse.onSuccess(TripPlaceConverter.toTripPlaceListDTOList(tripPlaces));
    }
}