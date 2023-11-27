package umc.spring.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.base.Code;
import umc.spring.base.exception.MissionException;
import umc.spring.domain.Mission;
import umc.spring.repository.MissionRepository;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MissionQueryServiceImpl implements IMissionQueryService{

    private final MissionRepository missionRepository;

    @Override
    public Mission findMission(Long id) {
        return missionRepository.findById(id)
                .orElseThrow(() -> {throw new MissionException(Code.MISSION_NOT_FOUND);});
    }
}
