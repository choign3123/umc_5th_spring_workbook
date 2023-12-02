package umc.spring.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.base.Code;
import umc.spring.base.exception.MissionException;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.repository.MissionRepository;
import umc.spring.service.StoreService.IStoreQueryService;
import umc.spring.web.dto.StoreResponse;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MissionQueryServiceImpl implements IMissionQueryService{

    private final MissionRepository missionRepository;
    private final IStoreQueryService storeQueryService;

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
}
