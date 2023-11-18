package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.base.Code;
import umc.spring.base.ResponseDto;
import umc.spring.converter.MemberConverter;
import umc.spring.domain.Member;
import umc.spring.service.MemberService.IMemberCommandService;
import umc.spring.web.dto.MemberRequest;
import umc.spring.web.dto.MemberResponse;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final IMemberCommandService memberCommandService;

    @PostMapping("/")
    public ResponseDto<MemberResponse.JoinDTO> join(@RequestBody @Valid MemberRequest.JoinDTO request){
        Member member = memberCommandService.joinMember(request);

        return ResponseDto.onSuccess(MemberConverter.toJoinDTO(member), Code.OK);
    }
}
