package hello.happy;

import hello.happy.member.Grade;
import hello.happy.member.Member;
import hello.happy.member.MemberService;
import hello.happy.member.MemberServiceImpl;
import hello.happy.order.Order;
import hello.happy.order.OrderService;
import hello.happy.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {

        AppConfig appConfig=new AppConfig();

        MemberService memberService=appConfig.memberService();
        OrderService orderService= appConfig.orderService();

        Long memberId=1L;
        Member kim = new Member(memberId, "kim", Grade.VIP);
        memberService.join(kim);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = "+order);
//        System.out.println("order = "+order.calculatePrice());


    }

}
