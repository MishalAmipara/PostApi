package com.example.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstanse {

    public static  Apiinterface  CallApi()
    {



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://amiparaandroid.000webhostapp.com/Myapp/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Apiinterface service = retrofit.create(Apiinterface.class);
        return  service;
    }

}
