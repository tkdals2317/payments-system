package com.dino.payments.controller

import com.dino.payments.controller.request.SignUpRequest
import com.dino.payments.domain.member.Member
import com.dino.payments.dto.ResponseDto
import com.dino.payments.service.MemberService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/members")
class MemberController(
    private val memberService: MemberService
) {
    @PostMapping("/sign-up")
    fun signUpMember(@RequestBody signUpRequest: SignUpRequest): ResponseEntity<ResponseDto> {
        memberService.signUpMember(signUpRequest)
        return ResponseEntity.ok(ResponseDto("회원가입 성공"))
    }
}