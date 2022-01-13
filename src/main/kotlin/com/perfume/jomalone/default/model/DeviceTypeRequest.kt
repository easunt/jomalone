package com.perfume.jomalone.default.model

data class DeviceTypeRequest(
    val code: String?, val name: String?, val capabilities: List<Long>?
)
