package com.perfume.jomalone.default.entity

import com.perfume.jomalone.common.entity.BaseEntity
import javax.persistence.*

@Entity
class CapabilityAttribute(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "attribute_id")
    val attribute: Attribute
) : BaseEntity() {

}