package com.rajdroid.countrydetails

import retrofit2.Response
import retrofit2.http.GET

interface CountryService {
    @GET("rest/v2/region/asia")
    suspend fun getCountry() : Response<Country>
}