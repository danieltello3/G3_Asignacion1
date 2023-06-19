package pe.edu.grupo3_asignacion1.models.requests

data class UserValidate (
    val id: Int = 0,
    var user: String = "",
    var password: String = "",
    val email: String = ""
)
