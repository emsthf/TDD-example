package com.ksa.eat.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "member")
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;
    @Column(nullable = false, unique = true, length = 30)   // DB에 var(200)을 줘도 이 비즈니스 로직을 먼저 거쳐서 가므로 30이 우선이 된다
    private String username;
    @Column(nullable = false, length = 100)
    private String name;

    public MemberEntity(String username, String name) {
        this.username = username;
        this.name = name;
    }
}
