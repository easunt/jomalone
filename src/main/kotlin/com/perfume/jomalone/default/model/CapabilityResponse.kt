package com.perfume.jomalone.default.model

import com.perfume.jomalone.default.entity.Capability

data class CapabilityResponse(
    val id: Long,
    val name: String,
    val attributes: List<Map<String, AttributeResponse>>
) {
    companion object {
        fun of(capability: Capability): CapabilityResponse {
            return CapabilityResponse(capability.id, capability.name, capability.capabilityAttributes.map {
                mapOf(it.attribute.name to AttributeResponse.of(it.attribute).copy(name = null)) })
            //TODO:: Space Complexity 관점에서 copy 가 그닥 좋지 않을듯... 개선필요
        }
    }
}