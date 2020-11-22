package com.example.webservice.api.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.webservice.R
import com.example.webservice.api.model.ApiResponseModel
import com.example.webservice.api.model.CharacterModel
import com.example.webservice.api.repository.Endpoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val client = getRetrofitInstance(BASE_URL)

        var endpoint = client.create(Endpoint::class.java)

        endpoint.obterPersonagens().enqueue(object: Callback<ApiResponseModel<CharacterModel>> {
            override fun onResponse(
                call: Call<ApiResponseModel<CharacterModel>>,
                response: Response<ApiResponseModel<CharacterModel>>
            ) {
                val resultado = response.body()
                Toast.makeText(this@MainActivity, resultado!!.results[0].nome, Toast.LENGTH_LONG).show()
            }

            override fun onFailure(call: Call<ApiResponseModel<CharacterModel>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Deu ruim na API", Toast.LENGTH_SHORT).show()
            }

        })
    }

    fun getRetrofitInstance(baseUrl: String): Retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    companion object {
        const val BASE_URL = "https://rickandmortyapi.com/api/"
    }
}