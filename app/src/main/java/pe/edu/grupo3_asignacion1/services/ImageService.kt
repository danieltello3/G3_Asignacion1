package pe.edu.grupo3_asignacion1.services

import pe.edu.grupo3_asignacion1.models.Photo
import pe.edu.grupo3_asignacion1.models.demo.PhotoList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ImageService{
    @GET("/user/pokemon")
    fun fetchImageByUserId(
        @Query("id") id : Int
    ): Call<PhotoList>
}