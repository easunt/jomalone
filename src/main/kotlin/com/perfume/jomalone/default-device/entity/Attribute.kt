package com.perfume.jomalone.`default-device`.entity

import com.perfume.jomalone.common.utils.converter.ListDataConverter
import javax.persistence.*

@Entity
class Attribute(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,
    val name: String,
    val min: Long?,
    val max: Long?,
    @Convert(converter = ListDataConverter::class)
    val supported: List<Any>?,
    @Convert(converter = ListDataConverter::class)
    val writable: List<Any>?,
    val mutability: String
) {
}