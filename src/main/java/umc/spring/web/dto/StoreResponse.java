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

    public static CreateStoreDTO toCreateStoreDTO(Store store){

        return CreateStoreDTO.builder()
                .storeId(store.getId())
                .build();
    }

    @AllArgsConstructor
    @Builder
    @Getter
    public static class CreateMissionDTO {

        @JsonProperty("mission_id")
        private Long missionId;
    }

    public static CreateMissionDTO toCreateMissionDTO(Mission mission){
        return CreateMissionDTO.builder()
                .missionId(mission.getId())
                .build();
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
}
