package umc.spring.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.domain.Store;

public class StoreRequest {

    @Getter
    @NoArgsConstructor
    public static class CreateStoreDTO {

        private String address;
        private String name;

        @JsonProperty("region_id")
        private Long regionId;
    }
}
