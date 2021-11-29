package com.perfume.jomalone.`default-device`.entity

import com.perfume.jomalone.common.entity.BaseEntity
import javax.persistence.*

@Entity
class Capability(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,
    val name: String,
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "capability_id")
    val capabilityAttributes: List<CapabilityAttribute>
) : BaseEntity() {
}