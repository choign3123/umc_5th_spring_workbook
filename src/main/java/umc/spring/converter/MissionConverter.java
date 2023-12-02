package umc.spring.converter;

import umc.spring.domain.Mission;
import umc.spring.web.dto.StoreRequest;

import java.time.LocalDate;

public class MissionConverter {

    public static Mission toMission(StoreRequest.CreateMissionDTO request){
        return Mission.builder()
                .reward(request.getReward())
                .deadline(LocalDate.parse(request.getDeadline()))
                .missionSpec(request.getMissionSpec())
                .build();
    }
}
