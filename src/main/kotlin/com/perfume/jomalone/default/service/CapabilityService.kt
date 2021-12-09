package com.perfume.jomalone.default.service

import com.perfume.jomalone.common.constant.ApiResult
import com.perfume.jomalone.common.exception.AppException
import com.perfume.jomalone.default.entity.Capability
import com.perfume.jomalone.default.entity.CapabilityRepository
import org.springframework.stereotype.Service

@Service
class CapabilityService(
    val capabilityRepository: CapabilityRepository
) {
    fun list(): List<Capability> {
        return capabilityRepository.findAll()
    }

    fun findOne(id: Long): Capability {
        return capabilityRepository.findById(id).orElseThrow { AppException(ApiResult.CAPABILITY_NOT_FOUND, null) }
    }
}