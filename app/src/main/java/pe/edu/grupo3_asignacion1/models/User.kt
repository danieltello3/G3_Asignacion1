package pe.edu.grupo3_asignacion1.models

import com.google.gson.annotations.SerializedName

data class User (
    var id: Int = 0,
    @SerializedName("user")
    var usuario: String = "",
    @SerializedName("name")
    var nombre: String = "",
    @SerializedName("email")
    var correo: String = "",
    @SerializedName("image_url")
    var imagen: String = "",
)
