package com.dylancaceres.EVC.data.repository.retroFit


import com.dylancaceres.EVC.model.Personaje
import retrofit2.Call
import retrofit2.http.GET

interface StarwarsInterface {
    @GET("v1/images/search?limit=10")
    fun  getAllPersonajes(): Call<List<Personaje>>
}