package umc.spring.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;

import java.time.LocalDate;
import java.util.List;

public class StoreResponse {

    @AllArgsConstructor
    @Builder
    @Getter
    public static class CreateStoreDTO {

        @JsonProperty("store_id")
        private Long storeId;
    }

    @AllArgsConstructor
    @Builder
    @Getter
    public static class CreateMissionDTO {

        @JsonProperty("mission_id")
        private Long missionId;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewPreViewListDTO{
        List<ReviewPreViewDTO> reviewList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewPreViewDTO{
        String ownerNickname;
        Float score;
        String body;
        LocalDate createdAt;
    }

    public static class MissionListDTO{

        @JsonProperty("missions")
        List<MissionDTO> missionList;

        @JsonProperty("list_size")
        Integer missionsSize;

        @JsonProperty("total_page")
        Integer totalPage;

        @JsonProperty("total_review")
        Long totalMission;

        @JsonProperty("is_first")
        Boolean isFirst;

        @JsonProperty("is_last")
        Boolean isLast;
    }

    public static class MissionDTO{
        @JsonProperty("mission_id")
        private Long missionId;
        private String spec;
        private int reward;
        private LocalDate deadline;
    }
}
