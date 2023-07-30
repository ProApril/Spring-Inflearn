package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor // lombok은 너무 좋은데?  기가막힌다. 생성자 만들어줌 @게터, @세터도 있음
public class OrderServiceImpl implements OrderService{
    // OCP 위반 된것임.
    //    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    private final MemberRepository memberRepository ; // final은 값이 무조건 있어야한다는 말임.
    private final DiscountPolicy discountPolicy ; // 인터페이스에만 의존하도록 하는 방법


//    @Autowired // 생성자가 하나일때는 오토와이얼드 없어도 인식된다.
//    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy){
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice){
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice); // 멤버 자체를 넘겻네?
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
