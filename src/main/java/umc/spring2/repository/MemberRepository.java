package umc.spring2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring2.domain.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByLoginId(String loginId);
}
