package com.dino.payments.controller.request

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "회원가입 요청 객체")
class SignUpRequest(
    @Schema(description = "이메일") val email: String,
    @Schema(description = "이름") val name: String,
    @Schema(description = "비밀번호") val password: String,
    @Schema(description = "나이") val age: Int? = null,
) {

}
