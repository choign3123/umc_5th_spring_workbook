package umc.spring.service.MissionService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.base.Code;
import umc.spring.base.exception.MissionException;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.repository.MissionRepository;
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

        // 마감일 Date타입으로 변환
        LocalDate deadline;
        try{
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            deadline = simpleDateFormat.parse(request.getDeadline())
                    .toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        } catch (ParseException e){
            throw new MissionException(Code.MISSION_DEADLINE_FORMAT_NOT_MATCH);
        }

        Mission newMission = Mission.builder()
                .reward(request.getReward())
                .deadline(deadline)
                .missionSpec(request.getMissionSpec())
                .build();

        // 양방향 맵핑
        newMission.setStore(store);

        return missionRepository.save(newMission);
    }
}
