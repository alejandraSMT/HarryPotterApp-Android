package com.example.harrypotterapp.data

import com.example.harrypotterapp.data.model.Character
import retrofit2.Call
import retrofit2.http.GET

interface HarryPoterrApiService {

    /*@GET("characters")
    fun getCharacters():Deferred<CharacterResponse>

    companion object{
        operator fun invoke(): HarryPoterrApiService {
            val requestInterceptor = Interceptor{chain ->
                val url = chain.request()
                    .url()
                    .newBuilder()
                    .build()
                val request = chain.request()
                    .newBuilder()
                    .url(url)
                    .build()
                return@Interceptor chain.proceed(request)
            }

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://hp-api.onrender.com/")
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(HarryPoterrApiService::class.java)
        }
    }*/

    @GET("characters")
    fun getCharacters(): Call<List<Character>>

}