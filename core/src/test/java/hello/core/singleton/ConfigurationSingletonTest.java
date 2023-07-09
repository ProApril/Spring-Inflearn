package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {
    @Test
    void configurationTest(){

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService",MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderSerivce", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository",MemberRepository.class);

        //MemberRepository memberRepository1 = memberService.getMemberRepository();
        //MemberRepository memberRepository2 = orderService.getMemberRepository();

        // !결론은 스프링에서 어떻게 호출하든 싱글톤으로 세팅되어있으면 같은 객체로 처리된다.
        // 자바코드상 두, 세번 호출하는것 같은데? 그렇게 안된다.
        // @Configuration 내에서 @Bean 메소드마다 싱글톤을 보장해준다.
    }
}
