package com.example.book_reading_app.API;

import com.example.book_reading_app.Model.UserModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface APIService {


    @FormUrlEncoded
    @POST("login")
    Call<UserModel> login(@Field("username_user") String username, @Field("hash_password_user") String password);

    @POST("signin")
    Call<UserModel> SignIn(@Body UserModel user);




}
