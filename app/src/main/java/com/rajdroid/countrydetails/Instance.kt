package com.rajdroid.countrydetails

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Instance {

    companion object{
        val BASE_URL = "https://restcountries.eu/"

        fun getRetrofitInstance(): Retrofit {
            return Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                    .build()
        }
    }
}