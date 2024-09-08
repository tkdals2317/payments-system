package com.dino.payments.global

import com.dino.payments.service.exceptions.ExistEmailException
import com.dino.payments.global.dto.ErrorMessageModel
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ExceptionControllerAdvice {

    @ExceptionHandler(ExistEmailException::class)
    fun handleExistEmailException(e: ExistEmailException): ResponseEntity<ErrorMessageModel> {
        return ResponseEntity.badRequest().body(
            ErrorMessageModel(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(), e.message)
        )
    }
}