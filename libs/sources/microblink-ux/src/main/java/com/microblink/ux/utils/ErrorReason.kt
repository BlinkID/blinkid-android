package com.microblink.ux.utils

import com.microblink.ux.state.ErrorState

/**
 * Specifies the error reason.
 */
enum class ErrorReason {
    ErrorInvalidLicense,
    ErrorNetworkError,
    ErrorTimeoutExpired,
    ErrorDocumentClassFiltered
}

fun ErrorReason.toErrorState(): ErrorState {
    return when(this) {
        ErrorReason.ErrorInvalidLicense -> ErrorState.ErrorInvalidLicense
        ErrorReason.ErrorNetworkError -> ErrorState.ErrorNetworkError
        ErrorReason.ErrorTimeoutExpired -> ErrorState.ErrorTimeoutExpired
        ErrorReason.ErrorDocumentClassFiltered -> ErrorState.ErrorDocumentClassFiltered
    }
}