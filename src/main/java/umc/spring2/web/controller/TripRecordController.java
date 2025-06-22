package umc.spring2.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.spring2.apiPayload.ApiResponse;
import umc.spring2.convert.TripRecordConverter;
import umc.spring2.service.Trip.TripRecordService;
import umc.spring2.web.dto.TripRecordRequestDTO;
import umc.spring2.web.dto.TripRecordResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/trip_records")

public class TripRecordController {
    private final TripRecordService tripRecordService;

    @PostMapping("/")
    public ApiResponse<TripRecordResponseDTO> createTripRecord(
            @RequestBody TripRecordRequestDTO dto) {
        TripRecordResponseDTO response = tripRecordService.createTripRecord(dto);
        return ApiResponse.onSuccess(response);
    }

    @GetMapping("/{trip_record_id}")
    public ApiResponse<TripRecordResponseDTO> getTripRecord(
            @PathVariable("trip_record_id") Long tripRecordId) {
        TripRecordResponseDTO response = tripRecordService.getTripRecordById(tripRecordId);
        return ApiResponse.onSuccess(response);
    }
}