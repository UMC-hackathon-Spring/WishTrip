package umc.spring2.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring2.convert.MemberConverter;
import umc.spring2.domain.Member;
import umc.spring2.dto.MemberRequestDTO;
import umc.spring2.dto.MemberResponseDTO;
import umc.spring2.service.MemberService;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;
}