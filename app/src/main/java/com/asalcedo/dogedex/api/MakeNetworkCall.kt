package com.asalcedo.dogedex.api

import com.asalcedo.dogedex.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.UnknownHostException

/**
 * Devuelve un genérico y le pasamos un lambda la cual va a realizar toda la llamada a la api
 */

suspend fun <T> makeNetworkCall(call: suspend () -> T): ApiResponseStatus<T> {
    return withContext(Dispatchers.IO) {
        try {
            ApiResponseStatus.Success(call())
        } catch (e: UnknownHostException) { //UnknownHostException se produce cuando na hay internet
            ApiResponseStatus.Error(R.string.unkown_host_exception_error)
        } catch (e: Exception) {
            ApiResponseStatus.Error(R.string.unkown_error)
        }

    }
}