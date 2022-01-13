package com.perfume.jomalone.default.entity

import com.perfume.jomalone.common.constant.ApiResult
import com.perfume.jomalone.common.constant.AppConstant
import com.perfume.jomalone.common.entity.BaseEntity
import com.perfume.jomalone.common.exception.AppException
import com.perfume.jomalone.default.model.CapabilityRequest
import com.perfume.jomalone.default.model.DeviceTypeRequest
import org.springframework.data.jpa.repository.JpaRepository
import javax.persistence.*

@Entity
class DeviceType(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L, var code: String, var name: String,
    @OneToMany(fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
    @JoinColumn(name = "device_type_id")
    var deviceTypeCapabilities: MutableList<DeviceTypeCapability>?

) : BaseEntity() {
    companion object {
        fun of(id: Long, deviceTypeRequest: DeviceTypeRequest, deviceTypeCapabilities: List<DeviceTypeCapability>?): DeviceType {
            if (deviceTypeRequest.name == null || deviceTypeRequest.code == null) {
                throw AppException(ApiResult.DEVICE_TYPE_REQUEST_INVALID, null)
            }
            return DeviceType(id, deviceTypeRequest.code, deviceTypeRequest.name, deviceTypeCapabilities?.toMutableList())
        }

        fun of(deviceTypeRequest: DeviceTypeRequest, deviceTypeCapabilities: List<DeviceTypeCapability>?): DeviceType {
            if (deviceTypeRequest.name == null || deviceTypeRequest.code == null) {
                throw AppException(ApiResult.DEVICE_TYPE_REQUEST_INVALID, null)
            }
            return DeviceType(AppConstant.NEW_ENEITY_ID, deviceTypeRequest.code, deviceTypeRequest.name, deviceTypeCapabilities?.toMutableList())
        }
    }

    fun modify(deviceTypeRequest: DeviceTypeRequest, deviceTypeCapabilities: List<DeviceTypeCapability>?) {
        deviceTypeRequest.name?.let { this.name = it }
        deviceTypeRequest.code?.let { this.code = it }
        deviceTypeCapabilities?.let { this.deviceTypeCapabilities = it.toMutableList() }
    }
}

interface DeviceTypeRepository : JpaRepository<DeviceType, Long> {}