package umc.spring.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;

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
}