package umc.spring.service.ReviewService;

import umc.spring.domain.Review;

public interface IReviewQueryService {

    public Review findReview(Long reviewId);
}
