package com.example.jpa;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Account {

    @Id @GeneratedValue
    private Long id;

    // 모든 항목에 @Column 이 생략되어 있지만 이렇게 명시해도 된다.
    @Column(nullable = false, unique = true)
    private String username;

    private String password;

    // Date, Calendar 만 지원
    @Temporal(TemporalType.TIMESTAMP)
    private Date created = new Date();

    private String yes;

    @Transient
    private String no;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "home_street"))
    })
    private Address home_address;

//    @Embedded
//    private Address office_address;

    // fk 있는 쪽이 owner ?
    // 양방향 관계 세팅하려면 mappedBy 설정해야 한다.
    @OneToMany(mappedBy = "owner")
    private Set<Study> studies = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Study> getStudies() {
        return studies;
    }

    public void setStudies(Set<Study> studies) {
        this.studies = studies;
    }

    // 주인은 스터디 이지만 many 쪽에서 관리할 때 이런식으로 쓰인다.
    // fk 가지고 있는 쪽이 주인
    public void addStudy(Study study) {
        study.setOwner(this);
        this.getStudies().add(study);
    }

    public void removeStudy(Study study) {
        study.setOwner(null);
        this.getStudies().remove(study);
    }
}
