package com.perfume.jomalone.default.entity

import com.perfume.jomalone.common.entity.BaseEntity
import org.springframework.data.jpa.repository.JpaRepository
import javax.persistence.*

@Entity
class Capability(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long = 0L,
    val name: String,
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "capability_id")
    val capabilityAttributes: List<CapabilityAttribute>
) : BaseEntity() {}

interface CapabilityRepository : JpaRepository<Capability, Long> {

}

