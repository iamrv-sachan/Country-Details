package com.rajdroid.countrydetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {


    private lateinit var retService: CountryService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            retService = Instance
                    .getRetrofitInstance()
                    .create(CountryService::class.java)

            val responseLiveData: LiveData<Response<Country>> = liveData {
                val respone = retService.getCountry()
                emit(respone)
            }

            responseLiveData.observe(this, Observer {

                val albumsList = it.body()?.listIterator()
                Log.i("Rajeev",albumsList.toString())
                if (albumsList!=null){

                    while (albumsList.hasNext()){
                        val albumsItem = albumsList.next()


                        val result:String= " "+"Country Name: ${albumsItem.name}"+"\n"+
                                " "+"Country Capital: ${albumsItem.capital}"+"\n"+
                                " "+"Country Population: ${albumsItem.population}"+"\n"+
                                " "+"Country Region: ${albumsItem.region}"+"\n"+
                                " "+"Country Sub-region: ${albumsItem.subregion}"+"\n"+
                                " "+"Country Borders: ${albumsItem.borders}"+"\n"+
                                " "+"Country Language: ${albumsItem.languages}"+"\n\n\n"


                        text_view.append(result)

                    }
                }

            })
        }
}