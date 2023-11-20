package umc.spring.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ReviewRequest {

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class AddReviewDTO{
        @JsonProperty("user_id")
        private Long userId;
        private Double rate;

        private String content;
    }
}
