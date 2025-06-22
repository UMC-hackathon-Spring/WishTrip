package umc.spring2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring2.domain.TripRecord;

import java.util.List;

public interface TripRecordRepository extends JpaRepository<TripRecord, Long> {
    // 특정 유저가 작성한 여행 기록 목록
    List<TripRecord> findByMemberId(Long memberId);
}
