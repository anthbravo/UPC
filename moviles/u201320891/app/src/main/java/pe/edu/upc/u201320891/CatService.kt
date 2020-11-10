package pe.edu.upc.u201320891

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface HeroeService {

    @GET("search/{name}")
    fun getHeroes(@Path("name") name: String): Call<SearchResponse>

}