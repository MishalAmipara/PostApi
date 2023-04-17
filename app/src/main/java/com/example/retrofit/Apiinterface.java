package com.example.retrofit;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Apiinterface {

    @FormUrlEncoded
    @POST("Register.php")
    Call<Registeruser> RegisterData(@Field("name") String name, @Field("email") String email, @Field("password") String password);
    @FormUrlEncoded
    @POST("login.php")
    Call<Registeruser> Login(@Field("email")String email, @Field("password") String password);
}
