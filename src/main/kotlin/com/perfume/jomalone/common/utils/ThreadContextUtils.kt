package com.perfume.jomalone.common.utils

import java.util.*

object ThreadContextUtils {
    private val contextHolder: ThreadLocal<ThreadContext> = ThreadLocal<ThreadContext>()

    fun getRequestId() = getContext().requestId

    fun getUserId() = getContext().userId

    fun getException() = getContext().exception

    fun getStackTrace(): List<StackTraceElement> {
        //FIXME-TAG
        return getException()?.let { exception ->
            exception.stackTrace.filter { it.className.startsWith("com.perfume.jomalone") }
        } ?: emptyList()
    }

    fun setException(exception: Exception) {
        getContext().exception = exception
    }

    fun removeAll() {
        contextHolder.remove()
    }


    private fun getContext(): ThreadContext {
        return contextHolder.get() ?: run {
            val threadContext = ThreadContext("HERMIONE-" + UUID.randomUUID(), 0, null)
            contextHolder.set(threadContext)
            return threadContext
        }
    }
}

class ThreadContext(
    var requestId: String,
    var userId: Long?,
    var exception: Exception?
) {
}