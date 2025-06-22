package umc.spring2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring2.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{

}
