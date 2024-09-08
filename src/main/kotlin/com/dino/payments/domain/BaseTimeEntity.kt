package com.dino.payments.domain

import jakarta.persistence.EntityListeners
import jakarta.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
open class BaseTimeEntity(
    @CreatedDate
    var createDatetime: LocalDateTime = LocalDateTime.now(),
    @LastModifiedDate
    var modifyDatetime: LocalDateTime = LocalDateTime.now()
) {
}