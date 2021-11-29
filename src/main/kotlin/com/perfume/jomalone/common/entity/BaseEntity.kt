package com.perfume.jomalone.common.entity

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass


@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class BaseEntity(
    @CreatedDate
    private var createdAt: LocalDateTime? = null,
    @LastModifiedDate
    private var  modifiedAt: LocalDateTime? = null
) {
    fun getCreatedAt() = createdAt

    fun getModifiedAt() = modifiedAt

}

