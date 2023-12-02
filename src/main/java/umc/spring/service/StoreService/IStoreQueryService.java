package umc.spring.service.StoreService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Review;
import umc.spring.domain.Store;

public interface IStoreQueryService {

    public Store findStore(Long storeId);

    public Page<Review> getReviewList(Long StoreId, Integer page);
}
