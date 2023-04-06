package exercise.springex1.domain;

import javax.persistence.*;

@Entity
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)     // db에서 id처럼 자동으로 입력되는 값
    private Long id;

    // @Column(name = "username")      // db table의 컬럼명 설정 가능
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
