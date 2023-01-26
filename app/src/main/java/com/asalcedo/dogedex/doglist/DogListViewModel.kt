package com.asalcedo.dogedex.doglist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asalcedo.dogedex.Dog
import com.asalcedo.dogedex.api.ApiResponseStatus
import kotlinx.coroutines.launch

class DogListViewModel : ViewModel() {
    private val dogRepository = DogRepository()

    private val _dogList = MutableLiveData<List<Dog>>()
    val dogList: LiveData<List<Dog>> get() = _dogList

    private val _status = MutableLiveData<ApiResponseStatus>()
    val status: LiveData<ApiResponseStatus> get() = _status

    //En cuanto incie el ViewModel vamos obtener los perros
    init {
        donwloadDogs()
    }

    private fun donwloadDogs() {
        viewModelScope.launch {
            _status.value = ApiResponseStatus.Loading()
            handleResponseStatus(dogRepository.donwloadDogs())
        }
    }

    private fun handleResponseStatus(apiResponseStatus: ApiResponseStatus) {
        if (apiResponseStatus is ApiResponseStatus.Success) {
            _dogList.value = apiResponseStatus.dogList
        }

        _status.value = apiResponseStatus
    }
}