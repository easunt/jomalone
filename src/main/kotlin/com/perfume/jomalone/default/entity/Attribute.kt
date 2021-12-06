package com.perfume.jomalone.default.entity

import com.perfume.jomalone.common.constant.ApiResult
import com.perfume.jomalone.common.entity.BaseEntity
import com.perfume.jomalone.common.exception.AppException
import com.perfume.jomalone.common.utils.converter.ListDataConverter
import com.perfume.jomalone.default.model.AttributeRequest
import org.springframework.data.jpa.repository.JpaRepository
import javax.persistence.*

@Entity
class Attribute(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long = 0L,
    var name: String,
    var minimum: Long?,
    var maximum: Long?,
    var step: Long?,
    @Convert(converter = ListDataConverter::class) var supported: List<Any>?,
    @Convert(converter = ListDataConverter::class) var writable: List<Any>?,
    var mutability: String
) : BaseEntity() {
    companion object {
        fun of(id: Long, attributeRequest: AttributeRequest): Attribute {
            if (attributeRequest.name == null || attributeRequest.mutability == null) {
                throw AppException(ApiResult.ATTRIBUTE_REQUEST_INVALID, null)
            }
            return Attribute(id, attributeRequest.name, attributeRequest.min, attributeRequest.max, attributeRequest.step, attributeRequest.supported, attributeRequest.writable, attributeRequest.mutability)
        }

        fun of(attributeRequest: AttributeRequest): Attribute {
            return this.of(0L, attributeRequest)
        }
    }

    fun modify(attributeRequest: AttributeRequest) {
        attributeRequest.name?.let { this.name = it }
        attributeRequest.min?.let { this.minimum = it }
        attributeRequest.max?.let { this.maximum = it }
        attributeRequest.step?.let { this.step = it }
        attributeRequest.supported?.let { this.supported = it }
        attributeRequest.writable?.let { this.writable = it }
        attributeRequest.mutability?.let { this.mutability = it }
    }
}

interface AttributeRepository : JpaRepository<Attribute, Long> {}