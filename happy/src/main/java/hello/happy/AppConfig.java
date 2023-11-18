package hello.happy;

import hello.happy.discount.DiscountPolicy;
import hello.happy.discount.FixDiscountPolicy;
import hello.happy.discount.RateDiscountPolicy;
import hello.happy.member.MemberService;
import hello.happy.member.MemberServiceImpl;
import hello.happy.member.MemoryMemberRepository;
import hello.happy.order.OrderService;
import hello.happy.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService(){ // 생성자 주입
        return new MemberServiceImpl(memberRepository());
    }

    private static MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
    }


}
