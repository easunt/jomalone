package com.perfume.jomalone.default.entity

import com.perfume.jomalone.common.constant.ApiResult
import com.perfume.jomalone.common.constant.AppConstant
import com.perfume.jomalone.common.entity.BaseEntity
import com.perfume.jomalone.common.exception.AppException
import com.perfume.jomalone.default.model.CapabilityRequest
import org.springframework.data.jpa.repository.JpaRepository
import javax.persistence.*

@Entity
class Capability(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L, var name: String,
    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "capability_id")
    var capabilityAttributes: MutableList<CapabilityAttribute>?
) : BaseEntity() {

    companion object {
        fun of(id: Long, capabilityRequest: CapabilityRequest, capabilityAttributes: List<CapabilityAttribute>?): Capability {
            if (capabilityRequest.name == null) {
                throw AppException(ApiResult.CAPABILITY_REQUEST_INVALID, null)
            }
            return Capability(id, capabilityRequest.name, capabilityAttributes?.toMutableList())
        }

        fun of(capabilityRequest: CapabilityRequest, capabilityAttributes: List<CapabilityAttribute>?): Capability {
            if (capabilityRequest.name == null) {
                throw AppException(ApiResult.CAPABILITY_REQUEST_INVALID, null)
            }
            return Capability(AppConstant.NEW_ENEITY_ID, capabilityRequest.name, capabilityAttributes?.toMutableList())
        }
    }

    fun modify(capabilityRequest: CapabilityRequest, capabilityAttributes: List<CapabilityAttribute>?) {
        capabilityRequest.name?.let { this.name = it }
        capabilityAttributes?.let { this.capabilityAttributes = it.toMutableList() }
    }
}

interface CapabilityRepository : JpaRepository<Capability, Long> {

}

