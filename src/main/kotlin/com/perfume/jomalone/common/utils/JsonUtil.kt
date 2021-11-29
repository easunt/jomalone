package com.perfume.jomalone.common.utils

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.PropertyAccessor
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.JavaType
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.KotlinModule

object JsonUtil {
    private val objectMapper: ObjectMapper =
        ObjectMapper().registerModule(KotlinModule()).registerModule(JavaTimeModule())

    fun getJacksonObjectMapper(): ObjectMapper {
        return ObjectMapper()
            .setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
    }

    fun toJsonString(obj: Any): String {
        return try {
            objectMapper.writeValueAsString(obj)
        } catch (e: Exception) {
            e.printStackTrace()
            throw e
        }
    }

    fun toObject(bytes: ByteArray): Any? {
        try {
            if (bytes.isEmpty()) {
                return null
            }
            return objectMapper.readValue(bytes, Any::class.java)

        } catch (e: Exception) {
            throw e
        }
    }

    fun <T> toObject(str: String?, clazz: Class<T>): T {
        return try {
            objectMapper.readValue(str, clazz)
        } catch (e: Exception) {
            throw e
        }
    }

    fun toJsonNode(str: String): JsonNode {
        return try {
            objectMapper.readTree(str)
        } catch (e: Exception) {
            throw e
        }
    }

    fun getType(clazz: Class<*>, subClazzz: Class<*>): JavaType? {
        return objectMapper.getTypeFactory().constructCollectionLikeType(clazz, subClazzz)
    }
}