package exercise.springex1;

import exercise.springex1.repository.MemberRepository;
import exercise.springex1.repository.MemoryMemberRepository;
import exercise.springex1.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}