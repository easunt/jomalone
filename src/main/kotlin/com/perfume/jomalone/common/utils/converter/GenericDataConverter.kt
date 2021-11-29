package com.perfume.jomalone.common.utils.converter

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.JavaType
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.slf4j.LoggerFactory
import javax.persistence.AttributeConverter

abstract class GenericDataConverter<T> : AttributeConverter<T, String> {

    private val logger = LoggerFactory.getLogger(javaClass)
    abstract val type: JavaType

    override fun convertToDatabaseColumn(meta: T?): String? {
        return try {
            jacksonObjectMapper().writeValueAsString(meta)
        } catch (ex: JsonProcessingException) {
            logger.error(ex.message, ex)
            getDefault()?.toString()
        }
    }

    override fun convertToEntityAttribute(dbData: String?): T? {
        return try {
            jacksonObjectMapper().readValue(dbData, type)
        } catch (ex: Exception) {
            logger.error(ex.message, ex)
            getDefault()
        }
    }

    abstract fun getDefault(): T?
}