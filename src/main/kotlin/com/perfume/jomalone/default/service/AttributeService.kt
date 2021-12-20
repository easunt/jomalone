package com.perfume.jomalone.default.service

import com.perfume.jomalone.common.constant.ApiResult
import com.perfume.jomalone.common.exception.AppException
import com.perfume.jomalone.default.entity.Attribute
import com.perfume.jomalone.default.entity.AttributeRepository
import com.perfume.jomalone.default.model.AttributeRequest
import org.springframework.stereotype.Service

@Service
class AttributeService(private val attributeRepository: AttributeRepository) {
    fun list(): List<Attribute> {
        return attributeRepository.findAll()
    }

    fun listByIds(ids: List<Long>): List<Attribute> {
        return attributeRepository.findAllById(ids)
    }

    fun findOne(id: Long): Attribute {
        return attributeRepository.findById(id).orElseThrow { AppException(ApiResult.ATTRIBUTE_NOT_FOUND, null) }
    }

    fun create(attribute: Attribute) {
        attributeRepository.save(attribute)
    }

    fun override(attribute: Attribute) {
        attributeRepository.save(attribute)
    }

    fun modify(id: Long, attributeRequest: AttributeRequest) {
        val attribute = this.findOne(id)
        attribute.modify(attributeRequest)
        attributeRepository.save(attribute)
    }

    fun delete(id: Long) {
        attributeRepository.deleteById(id)
    }
}