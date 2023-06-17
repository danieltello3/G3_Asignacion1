package pe.edu.grupo3_asignacion1.models

import com.google.gson.annotations.SerializedName

data class Photo(
    var id: Int = 0,
    var name: String="",
    var weight: Double = 0.0,
    var height: Double = 0.0,
    @SerializedName("image_url")
    var url: String = ""
)
