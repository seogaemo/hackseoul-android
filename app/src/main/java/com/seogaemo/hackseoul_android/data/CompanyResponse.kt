package com.seogaemo.hackseoul_android.data

data class CompanyResponse(
    val address: String,
    val businessNumber: String,
    val email: String,
    val licenseNumber: String,
    val name: String,
    val owner: String,
    val ownerPhoto: String,
    val phone: String,
    val type: Int,
    val uid: String
)