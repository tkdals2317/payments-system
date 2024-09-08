package com.dino.payments.controller

import com.dino.payments.controller.request.SignUpRequest
import com.dino.payments.global.dto.ResponseDto
import com.dino.payments.service.MemberService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/members")
@Tag(name = "회원 관련 API 컨트롤러")
class MemberController(
    private val memberService: MemberService
) {
    @PostMapping("/sign-up")
    @Operation(summary = "회원가입 API", description = "회원가입을 하여 멤버에 추가합니다.")
    fun signUpMember(@RequestBody signUpRequest: SignUpRequest): ResponseEntity<ResponseDto> {
        memberService.signUpMember(signUpRequest)
        return ResponseEntity.ok(ResponseDto(HttpStatus.OK, HttpStatus.OK.value(),"회원가입이 성공적으로 완료되었습니다."))
    }
}