package hello.happy.order;

import hello.happy.AppConfig;
import hello.happy.member.Grade;
import hello.happy.member.Member;
import hello.happy.member.MemberService;
import hello.happy.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach // 테스트를 실행하기전에 실행됨.
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder(){
        Long memberId = 1L;
        Member member=new Member(memberId,"kim", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "table", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);


    }

}
