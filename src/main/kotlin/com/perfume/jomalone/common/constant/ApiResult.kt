package com.perfume.jomalone.common.constant

import org.springframework.http.HttpStatus

enum class ApiResult(
    val httpStatus: HttpStatus,
    val code: Int,
    val defaultMessage: String
) {

    UNEXPECTED_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, 500_99_999, "Unexpected error"),
    //400
    ATTRIBUTE_REQUEST_INVALID(HttpStatus.BAD_REQUEST, 400_01_001, "attribute request is not valid. name and mutability is not-null type."),

    //404
    ATTRIBUTE_NOT_FOUND(HttpStatus.NOT_FOUND, 404_01_001, "attribute not found."),

    OK(HttpStatus.OK, 200_00_000, "OK");
}