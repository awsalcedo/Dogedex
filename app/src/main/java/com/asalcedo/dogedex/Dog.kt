package com.asalcedo.dogedex


import android.os.Parcelable
import com.asalcedo.dogedex.api.dto.DogDTO
import kotlinx.parcelize.Parcelize

/****
 * Project: Dogedex
 * From: com.asalcedo.dogedex
 * Created by Alex Salcedo Silva on 19/1/23 at 21:17
 * All rights reserve 2022.
 ***/
@Parcelize
data class Dog(
    val id: Long,
    val index: Int,
    val name: String,
    val type: String,
    val heightFemale: String,
    val heightMale: String,
    val imageUrl: String,
    val lifeExpectancy: String,
    val temperament: String,
    val weightFemale: String,
    val weightMale: String
) : Parcelable

fun DogDTO.toDomain() = Dog(
    id,
    index,
    name,
    type,
    heightFemale,
    heightMale,
    imageUrl,
    lifeExpectancy,
    temperament,
    weightFemale,
    weightMale
)