package exercise.springex1.repository;

import exercise.springex1.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{

    // Spring boot가 자동으로 EntityManager 생성(내부적으로 db통신 처리)
    // 개발자는 injection 받아서 사용만 하면 됨
    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    // PK를 기반으로 한 쿼리
    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    // PK가 아닌 컬럼을 기반으로 한 쿼리 - jpql
    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();

        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        // jpql - 테이블 대상으로 쿼리를 전송하는 것이 아닌 객체를 대상으로 쿼리 전송
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }
}
