package com.perfume.jomalone.default.model

import com.fasterxml.jackson.annotation.JsonInclude
import com.perfume.jomalone.default.entity.DeviceType

@JsonInclude(JsonInclude.Include.NON_NULL)
data class DeviceTypeResponse(
    val id: Long, val code: String, val name: String, val capabilities: List<CapabilityResponse>
) {
    companion object {
        fun of(deviceType: DeviceType): DeviceTypeResponse {
            return DeviceTypeResponse(deviceType.id, deviceType.name, deviceType.code, deviceType.deviceTypeCapabilities?.map {
                CapabilityResponse.of(it.capability)
            } ?: emptyList())
        }
    }
}
