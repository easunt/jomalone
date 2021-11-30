package com.perfume.jomalone.default.entity

import com.perfume.jomalone.common.utils.converter.ListDataConverter
import org.springframework.data.jpa.repository.JpaRepository
import javax.persistence.*

@Entity
class Attribute(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,
    val name: String,
    val minimum: Long?,
    val maximum: Long?,
    val step : Long?,
    @Convert(converter = ListDataConverter::class)
    val supported: List<Any>?,
    @Convert(converter = ListDataConverter::class)
    val writable: List<Any>?,
    val mutability: String
) {
}

interface AttributeRepository : JpaRepository<Attribute, Long> {
    override fun findAll() : List<Attribute>
    fun findOneById(id: Long) : Attribute?
}