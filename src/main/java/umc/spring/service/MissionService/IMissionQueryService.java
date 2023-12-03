package umc.spring.service.MissionService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;

public interface IMissionQueryService {

    public Mission findMission(Long id);
    public Page<Mission> getMissionList(Long storeId, int page);
    public Page<MemberMission> findMyMissionList(Long memberId, int page);
}
