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
    @ColumnInfo("user")
    var usuario: String = "",
    @SerializedName("password")
    @ColumnInfo(name = "password")
    var contrasenia: String = "",
    @SerializedName("name")
    @ColumnInfo("name")
    var nombre: String? = "",
    @SerializedName("email")
    @ColumnInfo("email")
    var correo: String = "",
    @SerializedName("image_url")
    @ColumnInfo("image_url")
    var imagen: String = "",
)
