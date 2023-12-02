package umc.spring.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.base.Code;
import umc.spring.base.exception.MissionException;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberMissionRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.service.MemberService.IMemberQueryService;
import umc.spring.service.StoreService.IStoreQueryService;
import umc.spring.web.dto.StoreResponse;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MissionQueryServiceImpl implements IMissionQueryService{

    private final MissionRepository missionRepository;
    private final IStoreQueryService storeQueryService;
    private final IMemberQueryService memberQueryService;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public Mission findMission(Long id) {
        return missionRepository.findById(id)
                .orElseThrow(() -> {throw new MissionException(Code.MISSION_NOT_FOUND);});
    }

    @Override
    public Page<Mission> getMissionList(Long storeId, int page){

        Store store = storeQueryService.findStore(storeId);

        Page<Mission> missionPage = missionRepository.findAllByStore(store, PageRequest.of(page, 10));

        return missionPage;
    }

    // 내가 진행중인 미션 목록 조회
    public Page<MemberMission> findMyMissionList(Long memberId, int page){

        Member member = memberQueryService.findMember(memberId);

        return memberMissionRepository.findAllByMemberOrderByCreatedAt(member, PageRequest.of(page, 10));
    }
}
