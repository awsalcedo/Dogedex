package com.asalcedo.dogedex.doglist


import com.asalcedo.dogedex.Dog
import com.asalcedo.dogedex.api.ApiResponseStatus
import com.asalcedo.dogedex.api.DogsApi.retrofitService
import com.asalcedo.dogedex.api.makeNetworkCall
import com.asalcedo.dogedex.toDomain


class DogRepository {
    suspend fun donwloadDogs(): ApiResponseStatus<List<Dog>> {
        return makeNetworkCall {
            val dogListApiResponse = retrofitService.getAllDogs()
            dogListApiResponse.data.dogs.map { it.toDomain() }
        }
    }

}