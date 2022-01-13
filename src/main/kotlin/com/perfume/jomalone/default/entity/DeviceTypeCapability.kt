package com.perfume.jomalone.default.entity

import com.perfume.jomalone.common.entity.BaseEntity
import org.springframework.data.jpa.repository.JpaRepository
import javax.persistence.*

@Entity
class DeviceTypeCapability(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "capability_id")
    val capability: Capability

) : BaseEntity() {
    companion object {
        fun of(capability: Capability): DeviceTypeCapability {
            return DeviceTypeCapability(0L, capability)
        }
    }
}

interface DeviceTypeCapabilityRepository : JpaRepository<CapabilityAttribute, Long>