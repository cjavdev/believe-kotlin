package com.believe.api.errors

open class BelieveException(message: String? = null, cause: Throwable? = null) :
    RuntimeException(message, cause)
