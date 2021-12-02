package com.perfume.jomalone.default.service

import com.perfume.jomalone.common.constant.ApiResult
import com.perfume.jomalone.common.exception.AppException
import com.perfume.jomalone.default.entity.Attribute
import com.perfume.jomalone.default.entity.AttributeRepository
import org.springframework.stereotype.Service

@Service
class AttributeService(
    private val attributeRepository: AttributeRepository
) {
    fun list(): List<Attribute> {
        return attributeRepository.findAll()
    }

    fun findOne(id: Long): Attribute {
        return attributeRepository.findById(id).orElseThrow { AppException(ApiResult.UNEXPECTED_ERROR, null) }
    }
}