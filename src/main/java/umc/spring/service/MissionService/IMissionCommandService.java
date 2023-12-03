package umc.spring.service.MissionService;

import umc.spring.domain.Mission;
import umc.spring.web.dto.StoreRequest;

import java.text.ParseException;

public interface IMissionCommandService {

    public Mission createMission(Long storeId, StoreRequest.CreateMissionDTO request);

    public void challengeMission(Long memberId, Long storeId, Long missionId);

    public void missionComplete(Long memberId, Long missionId);
}
