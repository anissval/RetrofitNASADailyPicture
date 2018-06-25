package com.`val`.aniss.retrofitnasadailypicture

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.`val`.aniss.retrofitnasadailypicture.api.NasaPictureRetriever
import com.`val`.aniss.retrofitnasadailypicture.model.NasaPicture
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var nasaRetriever = NasaPictureRetriever()
        val callback = object : Callback<NasaPicture> {
            override fun onFailure(call: Call<NasaPicture>?, t: Throwable?) {
                val message: String = "There was a failure"
            }

            override fun onResponse(call: Call<NasaPicture>?, response: Response<NasaPicture>?) {
                val message: String = "You got a response."
                if (response != null) {
                    NasaDate.text = response.body()?.date ?: "None"
                    NasaPictureTitle.text = response.body()?.title ?: "None"
                    Picasso.get().load(response.body()?.url).into(NasaDailyPicture)
                    NasaExplanation.text = response.body()?.explanation ?: "Not found"
                }

            }

        }
        nasaRetriever.getDailyPicture(callback)

    }
}
