package umc.spring2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import umc.spring2.domain.TripPlace;

import java.util.List;

public interface TripPlaceRepository extends JpaRepository<TripPlace, Long> {
    @Query("SELECT tp FROM TripPlace tp LEFT JOIN FETCH tp.tripRecord WHERE tp.member.id = :memberId")
    List<TripPlace> findAllWithTripRecordByMemberId(@Param("memberId") Long memberId);
}