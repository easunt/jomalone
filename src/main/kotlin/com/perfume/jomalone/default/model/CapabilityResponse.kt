package com.perfume.jomalone.default.model

import com.fasterxml.jackson.annotation.JsonInclude
import com.perfume.jomalone.default.entity.Capability

@JsonInclude(JsonInclude.Include.NON_NULL)
data class CapabilityResponse(
    val id: Long, val name: String?, val attributes: List<AttributeResponse>
) {
    companion object {
        fun of(capability: Capability): CapabilityResponse {
            return CapabilityResponse(capability.id, capability.name, capability.capabilityAttributes?.map {
                AttributeResponse.of(it.attribute)
            } ?: emptyList()) //TODO:: Space Complexity 관점에서 copy 가 그닥 좋지 않을듯... 개선필요
        }
    }
}