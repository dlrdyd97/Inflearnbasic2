package hello.happy;

import hello.happy.member.Grade;
import hello.happy.member.Member;
import hello.happy.member.MemberService;
import hello.happy.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {

//        AppConfig appConfig=new AppConfig();
//        MemberService memberService = appConfig.memberService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member kim = new Member(1L, "Kim", Grade.VIP);
        memberService.join(kim);

        Member findMember = memberService.findMember(1L);
        System.out.println("new Member = "+findMember.getName());
        System.out.println("find Member = "+kim.getName());

    }
}
