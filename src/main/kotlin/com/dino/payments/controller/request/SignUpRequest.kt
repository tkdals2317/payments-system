package com.dino.payments.controller.request

class SignUpRequest(
    val email: String,
    val name: String,
    val password: String,
    val age: Int? = null,
) {

}
