package gomip.core.order.service;

import gomip.core.annotation.MainDiscountPolicy;
import gomip.core.discount.service.DiscountPolicy;
import gomip.core.member.dto.Member;
import gomip.core.member.repository.MemberRepository;
import gomip.core.order.dto.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{
    // interface만 의존하도록 구현체를 넣지 않는다. -> 하지만 이대로 테스트 하면 npe 발생

    private final DiscountPolicy discountPolicy;
    private final MemberRepository memberRepository;


    // 여기 입장에서는 discountPolicy에 뭐가 들어올지 모르는 상황
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy){
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // test
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
 }
