package com.dino.payments.service

import com.dino.payments.domain.member.Member
import com.dino.payments.respository.MemberRepository
import org.springframework.stereotype.Service

@Service
class MemberService(
    private val memberRepository: MemberRepository
) {
    fun findAllMember(): List<Member> {
        return memberRepository.findAll()
    }
}