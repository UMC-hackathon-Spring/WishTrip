package umc.spring2.service.Trip;

import umc.spring2.domain.TripRecord;
import umc.spring2.web.dto.TripRecordRequestDTO;
import umc.spring2.web.dto.TripRecordResponseDTO;

import java.util.List;

public interface TripRecordService {
    TripRecordResponseDTO createTripRecord(TripRecordRequestDTO dto);

    TripRecordResponseDTO getTripRecordById(Long tripRecordId);
}
