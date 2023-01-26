package com.asalcedo.dogedex.api.responses

import com.squareup.moshi.Json

data class DogListApiResponse(
    @field:Json(name = "data") val data: DogListResponse,
    @field:Json(name = "is_success") val is_success: Boolean,
    @field:Json(name = "message") val message: String
)