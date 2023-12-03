package umc.spring.service.MemberService;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import umc.spring.domain.Member;
import umc.spring.domain.mapping.MemberMission;


public interface IMemberQueryService {

    public Member findMember(Long userId);
}
