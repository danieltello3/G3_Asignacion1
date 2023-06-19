package pe.edu.grupo3_asignacion1.models

import com.google.gson.annotations.SerializedName

data class Follows (
@SerializedName("id")
var usuarioId: Int = 0,
var name: String = "",
var user: String = "",
var email: String = "",
@SerializedName("image_url")
var imageUrl: String = "",
)