package umc.spring2.config.security;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import umc.spring2.domain.Member;
import umc.spring2.repository.MemberRepository;
import umc.study.workbook.domain.Member;
import umc.study.workbook.repository.MemberRepository.MemberRepository;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Member member = memberRepository.findByMemberId(username).orElseThrow(() -> new UsernameNotFoundException("해당 아이디를 가진 유저가 존재하지 않습니다: " + username));

        return org.springframework.security.core.userdetails.User
                .withUsername(member.getLoginId())
                .password(member.getLoginPwd())
                .roles(member.getRole())
                .build();
    }
}
