package umc.spring.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.base.Code;
import umc.spring.base.exception.ReviewException;
import umc.spring.domain.Review;
import umc.spring.repository.ReviewRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewQueryServiceImpl implements IReviewQueryService{

    private final ReviewRepository reviewRepository;

    public Review findReview(Long reviewId){
        return reviewRepository.findById(reviewId)
                .orElseThrow(() -> new ReviewException(Code.REVIEW_NOT_FOUND));
    }
}
