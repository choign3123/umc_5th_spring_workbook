package umc.spring.service.StoreService;

import umc.spring.domain.Store;
import umc.spring.web.dto.StoreRequest;

public interface IStoreCommandService {

    public Store createStore(StoreRequest.CreateStoreDTO request);
}
