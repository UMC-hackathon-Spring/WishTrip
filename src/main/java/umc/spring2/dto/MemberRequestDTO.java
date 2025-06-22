package umc.spring2.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.List;

public class MemberRequestDTO {

    @Getter
    @Setter
    @Schema(name = "MemberJoinDto", description = "회원가입 DTO")
    public static class JoinDto{
        @NotBlank
        String user_id;

        @NotBlank
        String user_pwd;

        @NotNull
        String phone_num;

        @NotNull
        String nickname;
    }

    @Getter
    @Setter
    public static class LoginRequestDTO{
        @NotBlank(message = "ID는 필수입니다.")
        private String user_id;

        @NotBlank(message = "패스워드는 필수입니다.")
        private String user_pwd;
    }
}