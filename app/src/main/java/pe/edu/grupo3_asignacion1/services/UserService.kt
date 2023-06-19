package pe.edu.grupo3_asignacion1.services

import pe.edu.grupo3_asignacion1.models.User
import pe.edu.grupo3_asignacion1.models.requests.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface UserService {
    @POST("/user/validate")
    suspend fun validate(@Body requestModel: UserValidate): Response<User>

    @POST("/user/create_account")
    suspend fun createAccount(@Body requestModel: UserCreate): Response<User>

    @POST("/user/reset_password")
    suspend fun resetPassword(@Body requestModel: UserResetPassword): Response<User>

    @GET("/user/get_username")
    suspend fun getUserName(
        @Query("usuario") usuario: String
    ): Response<User>

    @GET("/user/fetch_one")
    fun fetchOne(
        @Query("id") id: Int
    ): Call<User>

    @GET("/user/get_email")
    suspend fun getEmail(
        @Query("correo") email: String
    ): Response<User>
}