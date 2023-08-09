package com.onboarding.wanted.member.domain.service;

import com.onboarding.wanted.member.entity.MemberEntity;

import java.util.Optional;

public interface MemberRepository {
    Optional<MemberEntity> findByEmail(String email);
    boolean existsByEmail(String email);

    MemberEntity save(MemberEntity memberEntity);
}
