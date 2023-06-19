package pe.edu.grupo3_asignacion1.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "users")
data class User (
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0,
    @SerializedName("user")
    var usuario: String = "",
    @SerializedName("name")
    var nombre: String = "",
    @SerializedName("email")
    var correo: String = "",
    @SerializedName("image_url")
    @ColumnInfo(name = "image_url")
    var imagen: String = "",
)
