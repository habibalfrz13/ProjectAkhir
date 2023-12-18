package com.habib.projectakhirv4.api


import com.habib.projectakhirv4.model.ResponModel
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {
    @FormUrlEncoded
    @POST("register")
    fun register(
        @Field("name") name: String,
        @Field("username") username: String,
        @Field("email") email: String,
        @Field("no_hp") nomortlp: String,
        @Field("password") password: String,
    ): Call<ResponModel>


    @FormUrlEncoded
    @POST("login")
    fun login(
        @Field("username") username: String,
        @Field("password") password: String,
    ): Call<ResponModel>

}