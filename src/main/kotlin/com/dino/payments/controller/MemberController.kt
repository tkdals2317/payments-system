package com.dino.payments.controller

import com.dino.payments.controller.request.SignUpRequest
import com.dino.payments.global.dto.ResponseDto
import com.dino.payments.service.MemberService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
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
        return ResponseEntity.ok(ResponseDto(HttpStatus.OK, HttpStatus.OK.value(),"회원가입 성공"))
    }
}