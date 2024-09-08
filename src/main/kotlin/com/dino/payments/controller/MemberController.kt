package com.dino.payments.controller

import com.dino.payments.domain.member.Member
import com.dino.payments.service.MemberService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/members")
class MemberController(
    private val memberService: MemberService
) {

    @GetMapping("/all")
    fun getMembers(): List<Member> {
        return memberService.findAllMember()
    }
}