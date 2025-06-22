package umc.spring2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring2.domain.Member;
import umc.spring2.repository.MemberRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Optional<Member> getMemberById(Long id) {
        return memberRepository.findById(id);
    }
}
