package com.perfume.jomalone.common.response

import com.fasterxml.jackson.annotation.JsonInclude
import com.perfume.jomalone.common.constant.ApiResult
import org.springframework.http.HttpStatus

//FIXME :: change
@JsonInclude(JsonInclude.Include.NON_NULL)
data class JomaloneResponse(
    val httpStatus: HttpStatus,
    val code: Int,
    val message: String? = null,
    val data: Any? = null
) {
    //NOTE:: success constructor
    constructor(ApiResult: ApiResult, data: Any) : this(ApiResult.httpStatus, ApiResult.code, null, data)
    //NOTE:: exception constructor
    constructor(apiResult: ApiResult) : this(httpStatus = apiResult.httpStatus, code = apiResult.code, message = apiResult.defaultMessage)
}