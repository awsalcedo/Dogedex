package com.asalcedo.dogedex.api.responses

import com.asalcedo.dogedex.api.dto.DogDTO

data class DogListResponse(
    val dogs: List<DogDTO>
)