package com.emedinaa.infosoft2017.data.storage

import com.emedinaa.contactsapp.data.model.BaseReponseK
import com.emedinaa.infosoft2017.data.model.EventResponseK
import com.emedinaa.infosoft2017.data.model.SpeakerResponseK
import com.emedinaa.infosoft2017.data.model.SponsorResponseK
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import java.io.File
import java.util.*



/**
 * Created by emedinaa on 2/09/17.
 * https://blooming-oasis-63723.herokuapp.com
 * /speakers
 * /sponsors
 *
 * Caching
 * https://futurestud.io/tutorials/retrofit-2-activate-response-caching-etag-last-modified
 */
class ApliClientK {
    companion object {
        private var servicesApiInterface: ServicesApiInterface? = null
        private val API_BASE_URL = "https://blooming-oasis-63723.herokuapp.com"

        private fun interceptor(): HttpLoggingInterceptor {
            val httpLoggingInterceptor: HttpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            return httpLoggingInterceptor
        }

        private fun defaultCache():Cache{
            val cacheSize:Long=10 * 1024 * 1024;
            val cacheDir = File(System.getProperty("java.io.tmpdir"), UUID.randomUUID().toString())
            val cache:Cache= Cache(cacheDir,cacheSize)
            return  cache
        }

        fun getMyApiClient(): ServicesApiInterface {
            var builder: Retrofit.Builder = Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())

            var httpClient: OkHttpClient.Builder = OkHttpClient.Builder()
            httpClient.addInterceptor(interceptor())
            httpClient.cache(defaultCache())

            var retrofit: Retrofit = builder.client(httpClient.build()).build()
            servicesApiInterface = retrofit.create(
                    ServicesApiInterface::class.java)

            return servicesApiInterface as ServicesApiInterface
        }
    }
    interface ServicesApiInterface{
        @Headers("Content-Type: application/json")
        @GET("/v1/data/Contacts")
        fun contacts(@Query("where") query:String):Call<BaseReponseK>

        @Headers("Content-Type: application/json")
        @GET("/speakers")
        fun speakers():Call<SpeakerResponseK>

        @Headers("Content-Type: application/json")
        @GET("/sponsors")
        fun sponsors():Call<SponsorResponseK>

        @Headers("Content-Type: application/json")
        @GET("/workshops")
        fun workshops():Call<EventResponseK>

        @FormUrlEncoded
        @Headers("Content-Type: application/json")
        @POST("/events")
        fun events(@Field("date") mDate:String):Call<EventResponseK>
    }
}