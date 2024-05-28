package com.example.whatsapp.VMs.API


import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT

interface WhatsAppApi {
    @GET("user")
    suspend fun GetUserList(
    ):Response<UserInfoResponseList>


    @POST("user")
    suspend fun CreateUser(
        @Body userInfoResponseListItem: UserInfoResponseListItem
    ):Response<UserInfoResponseListItem>

    /*
    @POST("v1/auth/check-email")

    suspend fun checkemail(
        @Body checkemail: Checkemail
    ): Response<SimpleResponse>


    @GET("v1/use")
    suspend fun getUserInfo(
        @Header("Authorization") tokenUser:String
    ):Response<UserModel>

    @PUT("v1/users/person")
    suspend fun putUserInfo(
        @Header("Authorization") tokenUser:String,
        @Body updateUserModel: UpdateUserModel
    ):Response<UpdateUserResponseModel>


     */


}