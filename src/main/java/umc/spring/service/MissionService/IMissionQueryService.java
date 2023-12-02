package umc.spring.service.MissionService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;

public interface IMissionQueryService {

    public Mission findMission(Long id);
    public Page<Mission> getMissionList(Long storeId, int page);
}
