package com.prilepskiy.core.utils

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Request
import retrofit2.Response

sealed class ActionResult<out S> {
    data class Success<S>(val data: S) : ActionResult<S>()
    data class Error(val errors: Throwable) : ActionResult<Nothing>()
}

val <T> ActionResult<T>.data : T?
    get() = (this as? ActionResult.Success)?.data

suspend fun <R> makeApiCall(call: suspend () -> ActionResult<R>) = try {
    call()
} catch (e: Exception) {
    ActionResult.Error(e)
}

fun <Model> analyzeResponse(
    response: Response<Model>
): ActionResult<Model> {
    return when (response.code()) {
        200 -> {
            val responseBody = response.body()
            responseBody?.let {
                ActionResult.Success(it)
            } ?: ActionResult.Error(CallException(response.code(), response.message()))
        }
        else -> {
            ActionResult.Error(CallException(response.code(), response.message()))
        }
    }
}
data class CallException(
    val errorCode: Int,
    val errorMessage: String? = null,
) : Exception()

{
    companion object{
        const val TAG ="HeaderInterceptor"
    }
}