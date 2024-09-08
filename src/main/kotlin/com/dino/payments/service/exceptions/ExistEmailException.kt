package com.dino.payments.service.exceptions

class ExistEmailException: RuntimeException() {
    override val message: String = "이미 존재하는 이메일입니다."
}