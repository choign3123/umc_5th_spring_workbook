package umc.spring.service.ReviewService;

import umc.spring.domain.Review;
import umc.spring.web.dto.ReviewRequest;

public interface IReviewCommandService {

    public Review saveReview(Long storeId, ReviewRequest.AddReviewDTO request);
}
