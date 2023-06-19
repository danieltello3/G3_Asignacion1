package pe.edu.grupo3_asignacion1.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "photos")
data class Photo(
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0,
    var name: String="",
    var number: Int = 0,
    var weight: Double = 0.0,
    var height: Double = 0.0,
    @SerializedName("image_url")
    var url: String = ""
)
