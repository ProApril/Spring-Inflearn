package hello.core.discount;

import hello.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {
    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price){
        if (member.getGrade() == Grade.VIP){// ENUM 타입은 == 쓰는게 맞습니다.
            return discounntFixAmount;
        } else {
            return 0;
        }
    }
}
