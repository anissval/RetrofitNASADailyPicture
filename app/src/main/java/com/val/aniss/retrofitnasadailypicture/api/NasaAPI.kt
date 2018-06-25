package com.`val`.aniss.retrofitnasadailypicture.api

import com.`val`.aniss.retrofitnasadailypicture.model.NasaPicture
import retrofit2.Call
import retrofit2.http.GET

/**
 * @author Anahi Valdiviezo
 */
interface NasaAPI {
    //https://api.nasa.gov/planetary/apod?api_key=NNKOjkoul8n1CH18TWA9gwngW1s1SmjESPjNoUFo
    @GET("apod?api_key=NNKOjkoul8n1CH18TWA9gwngW1s1SmjESPjNoUFo")
    fun getDailyPicture () : Call<NasaPicture>
}