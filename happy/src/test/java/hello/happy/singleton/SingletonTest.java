package hello.happy.singleton;

import hello.happy.AppConfig;
import hello.happy.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer(){
        AppConfig appConfig = new AppConfig();

        // 1. 조회 : 호출할 때 마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();

        // 참조값이 다른 것을 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        // memberService2 != memberService2
        assertThat(memberService1).isNotSameAs(memberService2);

        // 현재 memberService 를 생성하면 repository 또한 생성되며 총 4개의 인스턴스를 생성
        // memberService1 , memberService2 , repo1 , repo 2
        // 이를 해결하기 위해 싱글톤 패턴을 사용할 것
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest(){

        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        // 이 전 테스트와 달리 같은 참조값을 보여줌
        System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonService2 = " + singletonService2);

        assertThat(singletonService1).isSameAs(singletonService2);
        // same  == 진짜 같은지 ( 참조값 포함 )
        // equal == 값이 같은지 ( 참조값 포함 x )
        // 이전 AppConfig 코드를 싱글톤 패턴으로 변경해야 하는가?
        // 스프링 컨테이너를 사용하면 기본적으로 객체를 다 싱글톤으로 변경해줌

    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer() {
        
//        AppConfig appConfig = new AppConfig();
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        // 1. 조회 : 호출을 여러번 해도 동일한 인스턴스를 가져옴
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        // 참조값이 같은 것을 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        // memberService2 == memberService2
        assertThat(memberService1).isSameAs(memberService2);

    }

}
