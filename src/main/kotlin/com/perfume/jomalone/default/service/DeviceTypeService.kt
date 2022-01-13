package com.perfume.jomalone.default.service

import com.perfume.jomalone.common.constant.ApiResult
import com.perfume.jomalone.common.exception.AppException
import com.perfume.jomalone.default.entity.*
import com.perfume.jomalone.default.model.CapabilityRequest
import com.perfume.jomalone.default.model.DeviceTypeRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DeviceTypeService(
    val deviceTypeRepository : DeviceTypeRepository,
    val capabilityService: CapabilityService
) {

    fun list(): List<DeviceType> {
        return deviceTypeRepository.findAll()
    }

    fun findOne(id: Long): DeviceType {
        return deviceTypeRepository.findById(id).orElseThrow { AppException(ApiResult.CAPABILITY_NOT_FOUND, null) }
    }

    fun create(deviceTypeRequest: DeviceTypeRequest) {
        val deviceTypeCapabilities = capabilityService.listByIds(deviceTypeRequest.capabilities)?.map { DeviceTypeCapability.of(it) }
        val deviceType = DeviceType.of(deviceTypeRequest, deviceTypeCapabilities)
        deviceTypeRepository.save(deviceType)
    }

    fun override(deviceTypeRequest: DeviceTypeRequest, id: Long) {
        val deviceTypeCapabilities = capabilityService.listByIds(deviceTypeRequest.capabilities)?.map { DeviceTypeCapability.of(it) }
        val deviceType = DeviceType.of(id, deviceTypeRequest, deviceTypeCapabilities)
        deviceTypeRepository.save(deviceType)
    }

    @Transactional
    fun modify(id: Long, deviceTypeRequest: DeviceTypeRequest) {
        val deviceType = this.findOne(id)
        val deviceTypeCapabilities = capabilityService.listByIds(deviceTypeRequest.capabilities)?.map { DeviceTypeCapability.of(it) }
        deviceType.modify(deviceTypeRequest, deviceTypeCapabilities)
    }

    fun delete(id: Long) {
        deviceTypeRepository.deleteById(id)
    }
}