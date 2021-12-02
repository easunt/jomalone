package com.perfume.jomalone.common.exception

import com.perfume.jomalone.common.constant.ApiResult
import java.lang.RuntimeException

class AppException(val apiResult: ApiResult, val customMessage: String?) : RuntimeException(customMessage ?: apiResult.defaultMessage)