package com.perfume.jomalone.default.entity

import com.perfume.jomalone.common.entity.BaseEntity
import com.perfume.jomalone.common.utils.converter.JpaJsonConverter
import javax.persistence.*

@Entity
class DeviceType(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,
    val code: String,
    val name: String,
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "device_type_id")
    val deviceTypeCapabilities: List<DeviceTypeCapability>

) : BaseEntity() {}