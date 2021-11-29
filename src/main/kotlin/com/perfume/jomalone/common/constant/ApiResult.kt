package com.perfume.jomalone.common.constant

import org.springframework.http.HttpStatus

enum class ApiResult(
    val httpStatus: HttpStatus,
    val code: Int,
    val defaultMessage: String
) {

    UNEXPECTED_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, 500_99_999, "Unexpected error"),
    OK(HttpStatus.OK, 200_00_000, "OK");
}