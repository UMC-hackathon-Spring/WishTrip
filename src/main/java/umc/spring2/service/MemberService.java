package umc.spring2.service;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring2.apiPayload.code.status.ErrorStatus;
import umc.spring2.apiPayload.exception.GeneralException;
import umc.spring2.config.security.jwt.JwtTokenProvider;
import umc.spring2.convert.MemberConverter;
import umc.spring2.domain.Member;
import umc.spring2.dto.MemberRequestDTO;
import umc.spring2.dto.MemberResponseDTO;
import umc.spring2.repository.MemberRepository;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public Member signupMember(MemberRequestDTO.JoinDto request){
        Member newMember = MemberConverter.toMember(request);
        newMember.encodePassword(passwordEncoder.encode(request.getUser_pwd()));
        return memberRepository.save(newMember);
    }

    public Member getMemberById(Long id){
        return memberRepository.findById(id).orElseThrow();
    }

    @Transactional
    public MemberResponseDTO.LoginResultDTO loginMember(MemberRequestDTO.LoginRequestDTO request){
        Member member = memberRepository.findByLoginId(request.getLoginId()).orElseThrow(()-> new GeneralException(ErrorStatus.MEMBER_NOT_FOUND));

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                member.getLoginId(), null,
                Collections.singleton(() -> "USER")
        );

        String accessToken = jwtTokenProvider.generateToken(authentication);

        return MemberConverter.toLoginResultDTO(
                member.getId(),
                accessToken
        );
    }

    public Member getMemberById(Long memberId) {
        return memberRepository.findById(memberId).orElseThrow(()-> new GeneralException(ErrorStatus.MEMBER_NOT_FOUND));
    }
}
