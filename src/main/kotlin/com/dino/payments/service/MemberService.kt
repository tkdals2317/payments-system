package com.dino.payments.service

import com.dino.payments.controller.request.SignUpRequest
import com.dino.payments.domain.member.Member
import com.dino.payments.service.exceptions.ExistEmailException
import com.dino.payments.respository.MemberRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class MemberService(
    private val memberRepository: MemberRepository
) {
    @Transactional
    fun signUpMember(signUpRequest: SignUpRequest) {
        if (memberRepository.existsByEmail(signUpRequest.email)) {
            throw ExistEmailException()
        }

        val newMember = Member(
            email = signUpRequest.email,
            name = signUpRequest.name,
            password = signUpRequest.password,
            age = signUpRequest.age
        )
        memberRepository.save(newMember)
    }
}