package com.example.dailynews_app.Api

import com.example.dailynews_app.util.Constants.Companion.BASEURL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance  {

    companion object{

        private val retrofit by lazy{
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)

            val client =OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()

            Retrofit.Builder()
                .baseUrl(BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()

        }
        val api by lazy {
            retrofit.create(NewsAPI::class.java)
        }
    }
}