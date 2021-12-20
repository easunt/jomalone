package com.perfume.jomalone.default.model

data class CapabilityRequest(
    val id: Long,
    val name: String?,
    val attributes: List<Long>?
)
