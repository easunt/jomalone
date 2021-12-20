package com.perfume.jomalone.default.controller

import com.perfume.jomalone.default.entity.Attribute
import com.perfume.jomalone.default.entity.Capability
import com.perfume.jomalone.default.model.CapabilityRequest
import com.perfume.jomalone.default.model.CapabilityResponse
import com.perfume.jomalone.default.service.CapabilityService
import org.springframework.web.bind.annotation.*

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

    @PostMapping("")
    fun create(@RequestBody capabilityRequest: CapabilityRequest) {
        return capabilityService.create(capabilityRequest)
    }

    @PutMapping("/{id}")
    fun override(@PathVariable id: Long, @RequestBody capabilityRequest: CapabilityRequest) {
        capabilityService.override(capabilityRequest, id)
    }

    @PatchMapping("/{id}")
    fun modify(@PathVariable id: Long, @RequestBody capabilityRequest: CapabilityRequest) {
        capabilityService.modify(id, capabilityRequest)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) {
        capabilityService.delete(id)
    }

}