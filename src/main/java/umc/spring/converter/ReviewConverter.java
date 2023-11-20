package umc.spring.converter;

import umc.spring.domain.Review;
import umc.spring.web.dto.ReviewRequest;
import umc.spring.web.dto.ReviewResponse;

public class ReviewConverter {

    public static Review toReview(ReviewRequest.AddReviewDTO request){

        return Review.builder()
                .body(request.getContent())
                .score(request.getRate().floatValue())
                .build();
    }

    public static ReviewResponse.AddReviewDTO toAddReviewDTO(Review review){

        return ReviewResponse.AddReviewDTO.builder()
                .reviewId(review.getId())
                .build();
    }
}
