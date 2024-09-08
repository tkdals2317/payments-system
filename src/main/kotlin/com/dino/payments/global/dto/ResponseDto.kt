package com.dino.payments.global.dto

import org.springframework.http.HttpStatus

class ResponseDto(
    var httpStatus: HttpStatus? = null,
    var status: Int? = null,
    val data: Any? = null
) {

}
