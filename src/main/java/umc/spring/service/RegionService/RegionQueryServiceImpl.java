package umc.spring.service.RegionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.base.Code;
import umc.spring.base.exception.RegionException;
import umc.spring.domain.Region;
import umc.spring.repository.RegionRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RegionQueryServiceImpl implements IRegionQueryService{

    private final RegionRepository regionRepository;

    @Override
    public Region findRegion(Long id) {
        return regionRepository.findById(id)
                .orElseThrow(() -> {throw new RegionException(Code.REGION_NOT_FOUND);});
    }
}
