package com.perfume.jomalone.`default-device`.entity

import com.perfume.jomalone.common.entity.BaseEntity
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
}