package umc.spring.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.validation.annotation.ExistCategories;

import java.util.List;

public class MemberRequest {

    @Getter
    @NoArgsConstructor
    public static class JoinDTO{
        String name;
        Integer gender;
        Integer birthYear;
        Integer birthMonth;
        Integer birthDay;
        String address;
        String specAddress;
        @ExistCategories
        List<Long> preferCategory;
    }

}
