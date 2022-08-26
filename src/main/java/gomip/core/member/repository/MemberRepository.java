package gomip.core.member.repository;

import gomip.core.member.dto.Member;

public interface MemberRepository {
    void save(Member member);

    Member findById(Long memberId);
}
