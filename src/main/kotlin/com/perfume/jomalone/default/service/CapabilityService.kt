package com.perfume.jomalone.default.service

import com.perfume.jomalone.common.constant.ApiResult
import com.perfume.jomalone.common.exception.AppException
import com.perfume.jomalone.default.entity.Capability
import com.perfume.jomalone.default.entity.CapabilityAttribute
import com.perfume.jomalone.default.entity.CapabilityRepository
import com.perfume.jomalone.default.model.CapabilityRequest
import org.springframework.stereotype.Service

@Service
class CapabilityService(
    val capabilityRepository: CapabilityRepository, val attributeService: AttributeService
) {
    fun list(): List<Capability> {
        return capabilityRepository.findAll()
    }

    fun findOne(id: Long): Capability {
        return capabilityRepository.findById(id).orElseThrow { AppException(ApiResult.CAPABILITY_NOT_FOUND, null) }
    }

    fun create(capabilityRequest: CapabilityRequest) {
        val attributeCapabilities = capabilityRequest.attributes?.let { attributeIds ->
            attributeService.listByIds(attributeIds).map { CapabilityAttribute.of(it) }
        } ?: emptyList()

        val capability = Capability.of(capabilityRequest, attributeCapabilities)
        capabilityRepository.save(capability)
    }

    fun override(capability: Capability) {
        capabilityRepository.save(capability)
    }

    fun modify(id: Long, capabilityRequest: CapabilityRequest) {
        val capability = this.findOne(id)
        capability.modify(capabilityRequest)
        capabilityRepository.save(capability)
    }

    fun delete(id: Long) {
        capabilityRepository.deleteById(id)
    }
}