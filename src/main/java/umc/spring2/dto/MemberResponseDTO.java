package umc.spring2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberResponseDTO {

    @Getter
    @AllArgsConstructor
    public static class MyNameDTO {
        private String my_name;
    }
}
