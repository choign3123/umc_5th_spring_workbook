package umc.spring.service.MemberService;

import org.springframework.stereotype.Service;
import umc.spring.domain.Member;


public interface IMemberQueryService {

    public Member findMember(Long userId);
}
