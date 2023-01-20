package com.asalcedo.dogedex

/****
 * Project: Dogedex
 * From: com.asalcedo.dogedex
 * Created by Alex Salcedo Silva on 19/1/23 at 21:17
 * All rights reserve 2022.
 ***/
data class Dog(
    val id: Long,
    val index: Int,
    val name: String,
    val type: String,
    val heightFemale: Double,
    val heightMale: Double,
    val imageUrl: String,
    val lifeExpectancy: String,
    val temperament: String,
    val weightFemale: Double,
    val weightMale: Double
)
