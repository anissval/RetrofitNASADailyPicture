package com.`val`.aniss.retrofitnasadailypicture.api

import com.`val`.aniss.retrofitnasadailypicture.model.NasaPicture
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author Anahi Valdiviezo
 */
class NasaPictureRetriever {

    private val service : NasaAPI

    init {
        val retrofit = Retrofit.Builder().baseUrl("https://api.nasa.gov/planetary/").addConverterFactory(GsonConverterFactory.create()).build()
        service = retrofit.create(NasaAPI::class.java)
    }

    fun getDailyPicture(callback : Callback<NasaPicture>) {
        val call = service.getDailyPicture()
        call.enqueue(callback)

    }


}