package hello.happy.order;

import hello.happy.discount.DiscountPolicy;
import hello.happy.discount.RateDiscountPolicy;
import hello.happy.member.Member;
import hello.happy.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl /* extends Object */ implements OrderService {


    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired // 생성자가 하나면 @Autowired 생략 가능
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 테스트용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
