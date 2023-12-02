package umc.spring.service.MissionService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.base.Code;
import umc.spring.base.exception.MissionException;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MissionRepository;
import umc.spring.service.MemberService.IMemberQueryService;
import umc.spring.service.StoreService.IStoreQueryService;
import umc.spring.web.dto.StoreRequest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionCommandServiceImpl implements IMissionCommandService{

    private final IStoreQueryService storeQueryService;
    private final MissionRepository missionRepository;
    private final IMemberQueryService memberQueryService;
    private final IMissionQueryService missionQueryService;

    /**
     * 가게에 미션 추가하기
     * @param storeId
     * @param request
     * @return
     */
    @Override
    @Transactional
    public Mission createMission(Long storeId, StoreRequest.CreateMissionDTO request){

        Store store = storeQueryService.findStore(storeId);

        Mission newMission = MissionConverter.toMission(request);

        // 양방향 맵핑
        newMission.setStore(store);

        return missionRepository.save(newMission);
    }

    /**
     * 미션 수행하기
     */
    public void challengeMission(Long memberId, Long storeId, Long missionId){
        Member member = memberQueryService.findMember(memberId);
        Store store = storeQueryService.findStore(storeId);
        Mission mission = missionQueryService.findMission(missionId);

        MemberMission memberMission = MemberMission.builder().build();

        memberMission.setMission(mission);
        memberMission.setMember(member);
    }
}
