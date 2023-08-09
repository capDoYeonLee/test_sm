package com.onboarding.wanted.member.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "member")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long memberId;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private MemberRoleEntity role;

    private String refreshToken;

    @Builder
    public MemberEntity(Long memberId, String email, String password, MemberRoleEntity role, String refreshToken) {
        this.memberId = memberId;
        this.email = email;
        this.password = password;
        this.role = role;
        this.refreshToken = refreshToken;
    }

    public void changedPassword(String password) {
        this.password = password;
    }

    public void updateRefreshToken(String newToken) {
        this.refreshToken = newToken;
    }
}
