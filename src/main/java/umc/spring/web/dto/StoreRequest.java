package umc.spring.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;

public class StoreRequest {

    @Getter
    @NoArgsConstructor
    public static class CreateStoreDTO {

        private String address;
        private String name;

        @JsonProperty("region_id")
        private Long regionId;
    }

    @Getter
    @NoArgsConstructor
    public static class CreateMissionDTO {

        private String deadline;

        @JsonProperty("mission_spec")
        private String missionSpec;

        private int reward;
    }
}
