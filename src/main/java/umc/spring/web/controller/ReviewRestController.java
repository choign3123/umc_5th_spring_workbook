package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.base.Code;
import umc.spring.base.ResponseDto;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Review;
import umc.spring.service.ReviewService.IReviewCommandService;
import umc.spring.web.dto.ReviewRequest;
import umc.spring.web.dto.ReviewResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/store")
public class ReviewRestController {

    private final IReviewCommandService reviewCommandService;

    // 가게에 리뷰 추가하기
    @PostMapping("/{store-id}/review")
    public ResponseDto<ReviewResponse.AddReviewDTO> addReview(@PathVariable("store-id") Long storeId, @RequestBody ReviewRequest.AddReviewDTO request){

        Review newReivew = reviewCommandService.saveReview(storeId, request);

        return ResponseDto.onSuccess(ReviewConverter.toAddReviewDTO(newReivew), Code.OK);
    }
}
