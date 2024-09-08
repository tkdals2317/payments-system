package com.dino.payments.controller

import com.dino.payments.controller.request.SignUpRequest
import com.dino.payments.global.dto.ResponseDto
import com.dino.payments.service.MemberService
import com.dino.payments.service.exceptions.ExistEmailException
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper


@WebMvcTest(MemberController::class)
class MemberControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var memberService: MemberService

    private val objectMapper = jacksonObjectMapper()

    @Test
    fun `회원가입 API 테스트`() {
        val signUpRequest = SignUpRequest("username", "password", "email@example.com")

        mockMvc.perform(
            MockMvcRequestBuilders.post("/members/sign-up")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(signUpRequest))
        )
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.jsonPath("$.httpStatus").value(HttpStatus.OK.name))
            .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(HttpStatus.OK.value()))
            .andExpect(MockMvcResultMatchers.jsonPath("$.data").value("회원가입이 성공적으로 완료되었습니다."))
    }
}