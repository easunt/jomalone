package com.perfume.jomalone.common.utils.converter

import com.fasterxml.jackson.databind.JavaType
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.perfume.jomalone.default.entity.Capability
import java.util.ArrayList
import javax.persistence.Converter

@Converter(autoApply = true)
class CapabilityConverter : GenericDataConverter<List<Capability>>() {
    private val defaultObjectMapper = jacksonObjectMapper()

    override val type: JavaType = defaultObjectMapper.typeFactory.constructCollectionType(ArrayList::class.java, Capability::class.java)
    override fun getDefault() = emptyList<Capability>()
}