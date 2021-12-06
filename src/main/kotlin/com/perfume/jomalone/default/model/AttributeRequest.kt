package com.perfume.jomalone.default.model

class AttributeRequest(
    val name: String?,
    val min: Long?,
    val max: Long?,
    val step: Long?,
    val supported: List<Any>?,
    val writable: List<Any>?,
    val mutability: String?
) {
}