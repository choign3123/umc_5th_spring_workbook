package umc.spring.service.ReviewService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Review;

public interface IReviewQueryService {

    public Review findReview(Long reviewId);
    public Page<Review> findMyReviewList(Long memberId, int page);
}
