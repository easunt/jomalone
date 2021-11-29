package com.perfume.jomalone.common.utils.converter

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import javax.persistence.AttributeConverter

class JpaJsonConverter : AttributeConverter<Any, String> {
    private val defaultObjectMapper = jacksonObjectMapper()

    override fun convertToEntityAttribute(dbData: String?): Any? {
        return dbData?.let { defaultObjectMapper.readValue(it) }
    }

    override fun convertToDatabaseColumn(attribute: Any?): String? {
        return defaultObjectMapper.writeValueAsString(attribute)
    }
}