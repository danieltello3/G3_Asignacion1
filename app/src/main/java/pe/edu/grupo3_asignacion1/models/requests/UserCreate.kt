package pe.edu.grupo3_asignacion1.models.requests

data class UserCreate(
    var user: String = "",
    var password: String = "",
    var email: String = ""
)
