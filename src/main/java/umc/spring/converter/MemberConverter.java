package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.enums.Gender;
import umc.spring.web.dto.MemberRequest;
import umc.spring.web.dto.MemberResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MemberConverter {

    public static MemberResponse.JoinDTO toJoinDTO(Member member){
        return MemberResponse.JoinDTO.builder()
                .memberId(member.getId())
                .createdAt(member.getCreatedAt())
                .build();
    }

    public static Member toMember(MemberRequest.JoinDTO request){
        Gender gender = null;

        switch (request.getGender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NONE;
                break;
        }

        return Member.builder()
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .gender(gender)
                .name(request.getName())
                .memberPreferList(new ArrayList<>())
                .build();
    }

    public static MemberResponse.MyReviewListDTO toMyReviewListDTO(Page<Review> reviewPage){

        List<MemberResponse.MyReviewDTO> myReviewDTOList = reviewPage.stream()
                .map(MemberConverter::toMyReviewDTO).collect(Collectors.toList());

        return MemberResponse.MyReviewListDTO.builder()
                .totalReview(reviewPage.getTotalElements())
                .listSize(myReviewDTOList.size())
                .totalPage(reviewPage.getTotalPages())
                .isFirst(reviewPage.isFirst())
                .isLast(reviewPage.isLast())
                .reviewList(myReviewDTOList)
                .build();
    }

    public static MemberResponse.MyReviewDTO toMyReviewDTO(Review review){
        return MemberResponse.MyReviewDTO.builder()
                .content(review.getBody())
                .score(review.getScore().doubleValue())
                .createdAt(review.getCreatedAt().toLocalDate())
                .build();
    }
}
