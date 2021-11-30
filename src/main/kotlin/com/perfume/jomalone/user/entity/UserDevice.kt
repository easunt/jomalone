package com.perfume.jomalone.user.entity

import com.perfume.jomalone.common.entity.BaseEntity
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class UserDevice(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,
    var name: String,
    var reachable: Boolean,
    val userId: Long,
) : BaseEntity() {

}