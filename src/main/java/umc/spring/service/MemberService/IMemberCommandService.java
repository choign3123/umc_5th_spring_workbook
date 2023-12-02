package umc.spring.service.MemberService;

import org.springframework.stereotype.Service;
import umc.spring.domain.Member;
import umc.spring.web.dto.MemberRequest;


public interface IMemberCommandService {

    public Member joinMember(MemberRequest.JoinDTO request);
}
