package com.perfume.jomalone.common.response

import com.perfume.jomalone.common.constant.ApiResult
import org.springframework.core.MethodParameter
import org.springframework.http.MediaType
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.server.ServerHttpRequest
import org.springframework.http.server.ServerHttpResponse
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice

@RestControllerAdvice("com.kep.hermione")
class HermioneResponseHandler : ResponseBodyAdvice<Any> {
    override fun supports(returnType: MethodParameter, converterType: Class<out HttpMessageConverter<*>>): Boolean {
        return true
    }

    override fun beforeBodyWrite(body: Any?, returnType: MethodParameter, selectedContentType: MediaType, selectedConverterType: Class<out HttpMessageConverter<*>>, request: ServerHttpRequest, response: ServerHttpResponse): Any {
        return when (body) {
            null -> HermioneResponse(ApiResult.OK)
            is HermioneResponse -> body
            else -> HermioneResponse(ApiResult.OK, body)
        }
    }
}