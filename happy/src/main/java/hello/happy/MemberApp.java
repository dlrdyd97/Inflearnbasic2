package hello.happy;

import hello.happy.member.Grade;
import hello.happy.member.Member;
import hello.happy.member.MemberService;
import hello.happy.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {

        AppConfig appConfig=new AppConfig();
        MemberService memberService = appConfig.memberService();

        Member kim = new Member(1L, "Kim", Grade.VIP);
        memberService.join(kim);

        Member findMember = memberService.findMember(1L);
        System.out.println("new Member = "+findMember.getName());
        System.out.println("find Member = "+kim.getName());

    }
}
