package com.perfume.jomalone.default.model

import com.fasterxml.jackson.annotation.JsonInclude
import com.perfume.jomalone.default.entity.Attribute

@JsonInclude(JsonInclude.Include.NON_NULL)
data class AttributeResponse(
    val name: String,
    val min: Long?,
    val max: Long?,
    val step: Long?,
    val supported: List<Any>?,
    val writable: List<Any>?,
    val mutability: String
) {
    companion object {
        fun of(attribute: Attribute): AttributeResponse {
            return AttributeResponse(attribute.name, attribute.minimum, attribute.maximum,
                attribute.step, attribute.supported, attribute.writable, attribute.mutability)
        }
    }
}