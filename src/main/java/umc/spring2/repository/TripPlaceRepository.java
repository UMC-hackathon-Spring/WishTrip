package umc.spring2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring2.domain.TripPlace;

import java.util.List;

public interface TripPlaceRepository extends JpaRepository <TripPlace, Long> {
    List<TripPlace> findByMemberId(Long memberId);
}
