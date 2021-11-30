package com.perfume.jomalone.common.exception

import com.perfume.jomalone.common.constant.ApiResult
import com.perfume.jomalone.common.response.HermioneResponse
import com.perfume.jomalone.common.utils.ThreadContextUtils
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class HermioneExceptionHandler {
    @ExceptionHandler
    fun handleExpectedException(ex: HermioneException): ResponseEntity<HermioneResponse> {
        ThreadContextUtils.setException(ex)
        return ResponseEntity(HermioneResponse(ex.apiResult), ex.apiResult.httpStatus)
    }

    @ExceptionHandler
    fun handleUnexpectedException(ex: Exception): ResponseEntity<HermioneResponse> {
        ex.printStackTrace()
        ThreadContextUtils.setException(ex)
        return ResponseEntity(HermioneResponse(ApiResult.UNEXPECTED_ERROR), ApiResult.UNEXPECTED_ERROR.httpStatus)
    }
}