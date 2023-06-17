package pe.edu.grupo3_asignacion1.services

import pe.edu.grupo3_asignacion1.models.User
import pe.edu.grupo3_asignacion1.models.demo.UserValidate
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface UserService{
    @POST("/user/validate")
    fun validate(
        @Body requestModel: UserValidate
    ): Call<Int>

    @GET("/user/fetch_one")
    fun fetchOne(
        @Query("id") id: Int
    ): Call<User>
}