package com.asalcedo.dogedex.doglist


import com.asalcedo.dogedex.Dog
import com.asalcedo.dogedex.R
import com.asalcedo.dogedex.api.ApiResponseStatus
import com.asalcedo.dogedex.api.DogsApi.retrofitService
import com.asalcedo.dogedex.toDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.UnknownHostException

class DogRepository {
    suspend fun donwloadDogs(): ApiResponseStatus<List<Dog>> {
        return withContext(Dispatchers.IO) {
            try {
                val dogListApiResponse = retrofitService.getAllDogs()
                ApiResponseStatus.Success(dogListApiResponse.data.dogs.map { it.toDomain() })
                /*val dogDTOMapper = DogDTOMapper()
                dogDTOMapper.fromDogDTOListToDogDomainList(dogDtOList)*/
            } catch (e: UnknownHostException) { //UnknownHostException se produce cuando na hay internet
                ApiResponseStatus.Error(R.string.unkown_host_exception_error)
            } catch (e: Exception) {
                ApiResponseStatus.Error(R.string.unkown_error)
            }

        }
    }

}