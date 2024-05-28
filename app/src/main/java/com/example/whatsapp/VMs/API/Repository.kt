package com.example.whatsapp.VMs.API


import retrofit2.Response

class Repository {
    suspend fun GetUsersList(): Response<UserInfoResponseList> {

        return RetrofitInstance.api.GetUserList()
    }


    suspend fun CreateUser(body:UserInfoResponseListItem): Response<UserInfoResponseListItem> {

        return RetrofitInstance.api.CreateUser(body)
    }
}