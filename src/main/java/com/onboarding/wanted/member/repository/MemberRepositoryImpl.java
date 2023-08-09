package com.onboarding.wanted.member.repository;

import com.onboarding.wanted.member.domain.service.MemberRepository;
import com.onboarding.wanted.member.entity.MemberEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepository {
    private final MemberJpaRepository memberRepository;

    @Override
    public Optional<MemberEntity> findByEmail(String email) {
        return memberRepository.findByEmail(email);
    }

    @Override
    public boolean existsByEmail(String email) {
        return memberRepository.existsByEmail(email);
    }

    @Override
    public MemberEntity save(MemberEntity memberEntity) {
        return memberRepository.save(memberEntity);
    }
}
