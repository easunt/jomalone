package com.perfume.jomalone.`default-device`.model

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class AttributeResponse(
    val name: String,
    val min: Long?,
    val max: Long?,
    val supported: List<Any>?,
    val writable: List<Any>?,
    val mutability: String
) {
}