package com.perfume.jomalone.default.controller

import com.perfume.jomalone.default.model.CapabilityRequest
import com.perfume.jomalone.default.model.CapabilityResponse
import com.perfume.jomalone.default.model.DeviceTypeRequest
import com.perfume.jomalone.default.model.DeviceTypeResponse
import com.perfume.jomalone.default.service.DeviceTypeService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/deviceTypes")
class DeviceTypeController(
    val deviceTypeService: DeviceTypeService
) {
    @GetMapping
    fun list(): List<DeviceTypeResponse> {
        return deviceTypeService.list().map { DeviceTypeResponse.of(it) }
    }

    @GetMapping("/{id}")
    fun findOne(@PathVariable id: Long): DeviceTypeResponse {
        return DeviceTypeResponse.of(deviceTypeService.findOne(id))
    }

    @PostMapping("")
    fun create(@RequestBody deviceTypeRequest: DeviceTypeRequest) {
        return deviceTypeService.create(deviceTypeRequest)
    }

    @PutMapping("/{id}")
    fun override(@PathVariable id: Long, @RequestBody deviceTypeRequest: DeviceTypeRequest) {
        deviceTypeService.override(deviceTypeRequest, id)
    }

    @PatchMapping("/{id}")
    fun modify(@PathVariable id: Long, @RequestBody deviceTypeRequest: DeviceTypeRequest) {
        deviceTypeService.modify(id, deviceTypeRequest)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) {
        deviceTypeService.delete(id)
    }
}