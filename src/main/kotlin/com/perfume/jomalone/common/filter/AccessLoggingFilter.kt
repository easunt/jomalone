package com.perfume.jomalone.common.filter

import com.perfume.jomalone.common.utils.JsonUtil
import com.perfume.jomalone.common.utils.ThreadContextUtils
import net.logstash.logback.argument.StructuredArguments
import org.apache.commons.lang.StringUtils
import org.slf4j.LoggerFactory
import org.springframework.web.filter.OncePerRequestFilter
import org.springframework.web.util.ContentCachingRequestWrapper
import org.springframework.web.util.ContentCachingResponseWrapper
import java.nio.charset.StandardCharsets
import java.time.Duration
import java.time.Instant
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class AccessLoggingFilter() : OncePerRequestFilter() {
    companion object {
        private val logstashLogger = LoggerFactory.getLogger("ACCESS")
    }

    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {
        if (isHealthCheck(request)) {
            filterChain.doFilter(request, response)
            ThreadContextUtils.removeAll()
            return
        }

        val startTime = Instant.now()
        val requestWrapper = ContentCachingRequestWrapper(request)
        val responseWrapper = ContentCachingResponseWrapper(response)
        var requestLoggingMap = mapOf<String, Any?>()
        var responseLoggingMap = mapOf<String, Any?>()

        try {
            filterChain.doFilter(requestWrapper, responseWrapper)
            val elapsedTime = Duration.between(startTime, Instant.now()).toMillis()
            val exception = ThreadContextUtils.getException()
            requestLoggingMap = createRequestLoggingMap(requestWrapper)
            responseLoggingMap = createResponseLoggingMap(responseWrapper)

            if (exception == null) {
                logstashLogger.info(
                    StringUtils.EMPTY,
                    StructuredArguments.value("elapsedTime", elapsedTime),
                    StructuredArguments.value("logType", "access"),
                    StructuredArguments.value("x-request-id", ThreadContextUtils.getRequestId()),
                    StructuredArguments.value("request", requestLoggingMap),
                    StructuredArguments.value("response", responseLoggingMap)
                )
            } else {
                throw exception
            }
        } catch (ex: Exception) {
            val elapsedTime = Duration.between(startTime, Instant.now()).toMillis()
            logstashLogger.error(
                StringUtils.EMPTY,
                StructuredArguments.value("elapsedTime", elapsedTime),
                StructuredArguments.value("logType", "access"),
                StructuredArguments.value("x-request-id", ThreadContextUtils.getRequestId()),
                StructuredArguments.value("request", requestLoggingMap),
                StructuredArguments.value("response", responseLoggingMap),
                StructuredArguments.value("exception", ThreadContextUtils.getStackTrace())
            )
        }
    }

    private fun isHealthCheck(request: HttpServletRequest): Boolean {
        return "/actuator/health" == request.requestURI
    }

    private fun createRequestLoggingMap(request: ContentCachingRequestWrapper): Map<String, Any?> {
        val headerMap = request.headerNames.toList().map { it to request.getHeader(it) }
        val paramsMap = request.parameterNames.toList().map { it to request.getParameter(it) }

        return mapOf(
            "url" to request.requestURL.toString(),
            "queryString" to request.queryString,
            "method" to request.method,
            "remoteAddr" to request.remoteAddr,
            "remoteHost" to request.remoteHost,
            "remotePort" to request.remotePort,
            "remoteUser" to request.remoteUser,
            "encoding" to request.characterEncoding,
            "header" to headerMap,
            "param" to paramsMap,
            "body" to JsonUtil.toObject(request.contentAsByteArray)
        )
    }

    private fun createResponseLoggingMap(response: ContentCachingResponseWrapper): Map<String, Any?> {
        val responseBody = if (response.contentAsByteArray.isNotEmpty()) String(response.contentAsByteArray, StandardCharsets.UTF_8) else null
        return mapOf(
            "status" to response.status,
            "body" to responseBody
        )
    }
}