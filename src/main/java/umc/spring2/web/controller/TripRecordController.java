package umc.spring2.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring2.apiPayload.ApiResponse;
import umc.spring2.convert.TripRecordConverter;
import umc.spring2.service.Trip.TripRecordService;
import umc.spring2.web.dto.TripRecordRequestDTO;
import umc.spring2.web.dto.TripRecordResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("trip_records/")

public class TripRecordController {
    private final TripRecordService tripRecordService;

    @PostMapping("{member_id}/")
    public ApiResponse<TripRecordResponseDTO> createTripRecord(
        @RequestBody TripRecordRequestDTO dto) {
        TripRecordResponseDTO response = tripRecordService.createTripRecord(dto);
        return ApiResponse.onSuccess(response);
    }
}
