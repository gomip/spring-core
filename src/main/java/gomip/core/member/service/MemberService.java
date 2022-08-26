package gomip.core.member.service;

import gomip.core.member.dto.Member;

public interface MemberService {
    void join(Member member);

    Member findMember(Long memberId);
}
