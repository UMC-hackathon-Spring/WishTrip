package umc.spring2.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

public class MemberRequestDTO {

    @Getter
    @Setter
    @Schema(name = "MemberJoinDto", description = "회원가입 DTO")
    public static class JoinDto{
        @NotBlank
        String loginId;

        @NotBlank
        String loginPwd;

        @NotNull
        String phone;

        @NotNull
        String nickname;
    }

    @Getter
    @Setter
    public static class LoginRequestDTO{
        @NotBlank(message = "ID는 필수입니다.")
        private String loginId;

        @NotBlank(message = "패스워드는 필수입니다.")
        private String loginPwd;
    }
}