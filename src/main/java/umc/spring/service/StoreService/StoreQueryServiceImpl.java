package umc.spring.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.base.Code;
import umc.spring.base.exception.StoreException;
import umc.spring.domain.Store;
import umc.spring.repository.StoreRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreQueryServiceImpl implements IStoreQueryService{

    private final StoreRepository storeRepository;

    @Override
    public Store findStore(Long storeId) {
        return storeRepository.findById(storeId)
                .orElseThrow(() -> new StoreException(Code.STORE_NOT_FOUND));
    }
}
