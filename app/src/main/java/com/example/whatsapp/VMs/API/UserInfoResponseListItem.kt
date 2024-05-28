package com.example.whatsapp.VMs.API

data class UserInfoResponseListItem(
    val bio: String,
    val id: String,
    val name: String,
    val password: String,
    val phone: String,
    val role: String
)