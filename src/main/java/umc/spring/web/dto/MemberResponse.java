package umc.spring.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class MemberResponse {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class JoinDTO{
        private Long memberId;
        LocalDateTime createdAt;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MyReviewListDTO{

        @JsonProperty("reviews")
        private List<MyReviewDTO> reviewList;

        @JsonProperty("list_size")
        Integer listSize;

        @JsonProperty("total_page")
        Integer totalPage;

        @JsonProperty("total_review")
        Long totalReview;

        @JsonProperty("is_first")
        Boolean isFirst;

        @JsonProperty("is_last")
        Boolean isLast;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MyReviewDTO{

        private Double score;

        private String content;

        @JsonProperty("created_at")
        private LocalDate createdAt;
    }
}
