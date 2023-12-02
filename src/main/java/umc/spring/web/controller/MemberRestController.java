package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.base.Code;
import umc.spring.base.ResponseDto;
import umc.spring.converter.MemberConverter;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.MemberService.IMemberCommandService;
import umc.spring.service.MemberService.IMemberQueryService;
import umc.spring.service.MissionService.IMissionQueryService;
import umc.spring.service.ReviewService.IReviewQueryService;
import umc.spring.web.dto.MemberRequest;
import umc.spring.web.dto.MemberResponse;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final IMemberCommandService memberCommandService;
    private final IReviewQueryService reviewQueryService;
    private final IMissionQueryService missionQueryService;

    @PostMapping("/")
    public ResponseDto<MemberResponse.JoinDTO> join(@RequestBody @Valid MemberRequest.JoinDTO request){
        Member member = memberCommandService.joinMember(request);

        return ResponseDto.onSuccess(MemberConverter.toJoinDTO(member), Code.OK);
    }

    @GetMapping("/reviews")
    public ResponseDto<MemberResponse.MyReviewListDTO> getMyReviewList(@RequestHeader("member_id") Long memberId, @RequestParam("page") int page){

        Page<Review> reviewPage = reviewQueryService.findMyReviewList(memberId, page);

        return ResponseDto.onSuccess(MemberConverter.toMyReviewListDTO(reviewPage), Code.OK);
    }

    // 내가 진행중인 미션 목록
    @GetMapping("/missions")
    public ResponseDto<MemberResponse.MyMissionListDTO> getMyMissionList(@RequestHeader("member_id") Long memberId, @RequestParam("page") int page){

        Page<MemberMission> memberMissionPage = missionQueryService.findMyMissionList(memberId, page);

        return ResponseDto.onSuccess(MissionConverter.toMyMissionListDTO(memberMissionPage), Code.OK);
    }
}
