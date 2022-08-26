package gomip.core.config;

import gomip.core.discount.service.DiscountPolicy;
import gomip.core.discount.service.FixDiscountPolicy;
import gomip.core.discount.service.RateDiscountPolicy;
import gomip.core.member.repository.MemberRepository;
import gomip.core.member.repository.MemoryMemberRepository;
import gomip.core.member.service.MemberService;
import gomip.core.member.service.MemberServiceImpl;
import gomip.core.order.service.OrderService;
import gomip.core.order.service.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


// 애플리케이션의 실제 동작에 필요한 구현 객체를 생성
// 생성한 객체 인스턴스의 참조를 생성자를 통해서 주입
// 역할 구현 구분
@Configuration
public class AppConfig {
    @Bean
    // 생성자 주입
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(),discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        System.out.println("call AppConfig.discountPolicy");
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
