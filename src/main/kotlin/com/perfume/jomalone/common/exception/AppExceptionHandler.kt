package com.perfume.jomalone.common.exception

import com.perfume.jomalone.common.constant.ApiResult
import com.perfume.jomalone.common.response.JomaloneResponse
import com.perfume.jomalone.common.utils.ThreadContextUtils
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class AppExceptionHandler {
    @ExceptionHandler
    fun handleExpectedException(ex: AppException): ResponseEntity<JomaloneResponse> {
        ThreadContextUtils.setException(ex)
        return ResponseEntity(JomaloneResponse(ex.apiResult), ex.apiResult.httpStatus)
    }

    @ExceptionHandler
    fun handleUnexpectedException(ex: Exception): ResponseEntity<JomaloneResponse> {
        ex.printStackTrace()
        ThreadContextUtils.setException(ex)
        return ResponseEntity(JomaloneResponse(ApiResult.UNEXPECTED_ERROR), ApiResult.UNEXPECTED_ERROR.httpStatus)
    }
}