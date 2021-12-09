package com.perfume.jomalone.default.controller

import com.perfume.jomalone.default.entity.Capability
import com.perfume.jomalone.default.model.CapabilityResponse
import com.perfume.jomalone.default.service.CapabilityService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/capabilities")
class CapabilityController(
    val capabilityService: CapabilityService
) {
    @GetMapping
    fun list(): List<CapabilityResponse> {
        return capabilityService.list().map { CapabilityResponse.of(it) }
    }

    @GetMapping("/{id}")
    fun findOne(@PathVariable id: Long): CapabilityResponse {
        return CapabilityResponse.of(capabilityService.findOne(id))
    }

}