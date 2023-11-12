package hello.happy.order;

import hello.happy.member.Grade;
import hello.happy.member.Member;
import hello.happy.member.MemberService;
import hello.happy.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService=new MemberServiceImpl();
    OrderService orderService=new OrderServiceImpl();

    @Test
    void createOrder(){
        Long memberId = 1L;
        Member member=new Member(memberId,"kim", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "table", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);


    }

}
