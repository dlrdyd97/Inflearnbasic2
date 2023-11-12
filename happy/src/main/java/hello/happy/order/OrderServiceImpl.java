package hello.happy.order;

import hello.happy.discount.DiscountPolicy;
import hello.happy.discount.FixDiscountPolicy;
import hello.happy.member.Member;
import hello.happy.member.MemberRepository;
import hello.happy.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository=new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
