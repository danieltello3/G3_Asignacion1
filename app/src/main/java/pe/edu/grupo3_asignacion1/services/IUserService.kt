package pe.edu.grupo3_asignacion1.services

import okhttp3.ResponseBody
import pe.edu.grupo3_asignacion1.models.User
import pe.edu.grupo3_asignacion1.models.requests.PasswordUpdate
import pe.edu.grupo3_asignacion1.models.requests.PasswordValidate
import pe.edu.grupo3_asignacion1.models.requests.UserUpdate
import pe.edu.grupo3_asignacion1.models.requests.UserValidate
import pe.edu.grupo3_asignacion1.models.responses.GenericResponse
import pe.edu.grupo3_asignacion1.models.responses.UpdateResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface IUserService {
    @Headers("Content-Type: application/json")
    @POST("/user/update")
    suspend fun updateUser(@Body requestModel: UserUpdate): Response<UpdateResponse>

    @Headers("Content-Type: application/json")
    @POST("/user/password")
    suspend fun updatePassword(@Body requestModel: PasswordUpdate): Response<GenericResponse>

    @Headers("Content-Type: application/json")
    @POST("/user/validate/password")
    suspend fun validatePassword(@Body requestModel: PasswordValidate): Response<GenericResponse>

    @Headers("Content-Type: application/json")
    @POST("/user/validate/unique")
    suspend fun validateUnique(@Body requestModel: UserValidate): Response<GenericResponse>
}