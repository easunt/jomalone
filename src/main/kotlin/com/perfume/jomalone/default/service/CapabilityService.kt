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
        val capabilityAttributes = attributeService.listByIds(capabilityRequest.attributes)?.map { CapabilityAttribute.of(it) }
        val capability = Capability.of(capabilityRequest, capabilityAttributes)
        capabilityRepository.save(capability)
    }

    fun override(capabilityRequest: CapabilityRequest, id: Long) {
        val capabilityAttributes = attributeService.listByIds(capabilityRequest.attributes)?.map { CapabilityAttribute.of(it) }
        val capability = Capability.of(id, capabilityRequest, capabilityAttributes)
        capabilityRepository.save(capability)
    }

    fun modify(id: Long, capabilityRequest: CapabilityRequest) {
        val capability = this.findOne(id)
        val capabilityAttributes = attributeService.listByIds(capabilityRequest.attributes)?.map { CapabilityAttribute.of(it) }
        capability.modify(capabilityRequest, capabilityAttributes)
        capabilityRepository.save(capability)
    }

    fun delete(id: Long) {
        capabilityRepository.deleteById(id)
    }
}