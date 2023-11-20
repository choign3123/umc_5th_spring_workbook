package umc.spring.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.base.Code;
import umc.spring.base.exception.ReviewException;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.repository.ReviewRepository;
import umc.spring.service.MemberService.IMemberQueryService;
import umc.spring.service.StoreService.IStoreQueryService;
import umc.spring.web.dto.ReviewRequest;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements IReviewCommandService{

    private final ReviewRepository reviewRepository;
    private final IMemberQueryService memberQueryService;
    private final IStoreQueryService storeQueryService;

    @Override
    public Review saveReview(Long storeId, ReviewRequest.AddReviewDTO request) {

        // 가게 찾기
        Store store = storeQueryService.findStore(storeId);

        // 유저 찾기
        Member member = memberQueryService.findMember(request.getUserId());

        // 리뷰 생성
        Review newReview = ReviewConverter.toReview(request);

        // 양방향 설정
        newReview.setStore(store);
        newReview.setMember(member);

        // 리뷰 저장
        return reviewRepository.save(newReview);
    }


}
