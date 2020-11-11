package pe.edu.upc.u201320891

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CatService {

    @GET("images/search")
    fun getCats(): Call<List<Cat>>

}