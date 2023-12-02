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

    // 내가 진행중인 미션 목록
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MyMissionListDTO{

        @JsonProperty("missions")
        private List<MyMissionDTO> missionList;

        @JsonProperty("missions_size")
        Integer missionsSize;

        @JsonProperty("total_page")
        Integer totalPage;

        @JsonProperty("total_mission")
        Long totalMission;

        @JsonProperty("is_first")
        Boolean isFirst;

        @JsonProperty("is_last")
        Boolean isLast;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MyMissionDTO{

        @JsonProperty("mission_id")
        private Long missionId;

        @JsonProperty("store_name")
        private String storeName;

        @JsonProperty("mission_spec")
        private String missionSpec;

        @JsonProperty("mission_reward")
        private Integer missionReward;

        @JsonProperty("created_at")
        private LocalDateTime createdAt;
    }
}
