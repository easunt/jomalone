package com.perfume.jomalone.default.entity

import com.perfume.jomalone.common.constant.ApiResult
import com.perfume.jomalone.common.entity.BaseEntity
import com.perfume.jomalone.common.exception.AppException
import com.perfume.jomalone.default.model.AttributeRequest
import com.perfume.jomalone.default.model.CapabilityRequest
import org.springframework.data.jpa.repository.JpaRepository
import javax.persistence.*

@Entity
class Capability(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,
    var name: String,
    @OneToMany(fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
    @JoinColumn(name = "capability_id")
    val capabilityAttributes: List<CapabilityAttribute>
) : BaseEntity() {

    companion object {
        fun of(id: Long, capabilityRequest: CapabilityRequest): Capability {
            if (capabilityRequest.name == null) {
                throw AppException(ApiResult.CAPABILITY_REQUEST_INVALID, null)
            }
            return Capability(capabilityRequest.id, capabilityRequest.name, emptyList())
        }

        fun of(capabilityRequest: CapabilityRequest, capabilityAttributes: List<CapabilityAttribute>): Capability {
            if (capabilityRequest.name == null) {
                throw AppException(ApiResult.CAPABILITY_REQUEST_INVALID, null)
            }
            return Capability(0L, capabilityRequest.name, capabilityAttributes)
        }
    }

    fun modify(capabilityRequest: CapabilityRequest) {
        capabilityRequest.name?.let { this.name = it }
    }
}

interface CapabilityRepository : JpaRepository<Capability, Long> {

}

