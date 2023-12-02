package umc.spring.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;

public class ReviewResponse {

    @AllArgsConstructor
    @Builder
    public static class AddReviewDTO{
        @JsonProperty("review_id")
        private Long reviewId;
    }
}
