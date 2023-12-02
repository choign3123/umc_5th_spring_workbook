package umc.spring.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.base.Code;
import umc.spring.base.exception.ReviewException;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.repository.ReviewRepository;
import umc.spring.service.MemberService.IMemberQueryService;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewQueryServiceImpl implements IReviewQueryService{

    private final ReviewRepository reviewRepository;
    private final IMemberQueryService memberQueryService;

    public Review findReview(Long reviewId){
        return reviewRepository.findById(reviewId)
                .orElseThrow(() -> new ReviewException(Code.REVIEW_NOT_FOUND));
    }

    public Page<Review> findMyReviewList(Long memberId, int page){
        Member member = memberQueryService.findMember(memberId);

        return reviewRepository.findAllByMember(member, PageRequest.of(page, 10));
    }
}
