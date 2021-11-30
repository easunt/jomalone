package com.perfume.jomalone.default.controller

import com.perfume.jomalone.default.entity.Attribute
import com.perfume.jomalone.default.model.AttributeResponse
import com.perfume.jomalone.default.service.AttributeService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RequestMapping("api/v1/attributes")
@RestController
class AttributeController(
    val attributeService: AttributeService
) {
    @GetMapping("")
    fun list(): List<AttributeResponse> {
        return attributeService.list().map { AttributeResponse.of(it) }
    }

    @GetMapping("/{id}")
    fun findOne(@PathVariable id: Long): AttributeResponse {
        return AttributeResponse.of(attributeService.findOne(id))
    }
}