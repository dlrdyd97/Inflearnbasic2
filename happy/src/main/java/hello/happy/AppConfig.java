package hello.happy;

import hello.happy.discount.DiscountPolicy;
import hello.happy.discount.FixDiscountPolicy;
import hello.happy.discount.RateDiscountPolicy;
import hello.happy.member.MemberService;
import hello.happy.member.MemberServiceImpl;
import hello.happy.member.MemoryMemberRepository;
import hello.happy.order.OrderService;
import hello.happy.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean // 메서드 이름을 스프링 빈의 이름으로 사용함
    public MemberService memberService(){ // 생성자 주입
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }



}
