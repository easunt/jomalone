package com.perfume.jomalone.default.controller

import com.perfume.jomalone.default.entity.Attribute
import com.perfume.jomalone.default.model.AttributeRequest
import com.perfume.jomalone.default.model.AttributeResponse
import com.perfume.jomalone.default.service.AttributeService
import org.springframework.web.bind.annotation.*

@RequestMapping("api/v1/attributes")
@RestController
class AttributeController(val attributeService: AttributeService) {
    @GetMapping("")
    fun list(): List<AttributeResponse> {
        return attributeService.list().map { AttributeResponse.of(it) }
    }

    @GetMapping("/{id}")
    fun findOne(@PathVariable id: Long): AttributeResponse {
        return AttributeResponse.of(attributeService.findOne(id))
    }

    @PostMapping("")
    fun create(@RequestBody attributeRequest: AttributeRequest) {
        return attributeService.create(Attribute.of(attributeRequest))
    }

    @PutMapping("/{id}")
    fun override(@PathVariable id: Long, @RequestBody attributeRequest: AttributeRequest) {
        attributeService.override(Attribute.of(id, attributeRequest))
    }

    @PatchMapping("/{id}")
    fun modify(@PathVariable id: Long, @RequestBody attributeRequest: AttributeRequest) {
        attributeService.modify(id, attributeRequest)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) {
        attributeService.delete(id)
    }
}