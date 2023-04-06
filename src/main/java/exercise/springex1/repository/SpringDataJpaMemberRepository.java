package exercise.springex1.repository;

import exercise.springex1.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    // 공통적인 컬럼 이름이 아니기 때문에 개발자가 따로 만들어야 함
    // select m from Member m where m.name = ?
    @Override
    Optional<Member> findByName(String name);
}
