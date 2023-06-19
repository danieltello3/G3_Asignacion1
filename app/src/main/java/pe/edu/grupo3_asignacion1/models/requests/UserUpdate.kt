package pe.edu.grupo3_asignacion1.models.requests

data class UserUpdate(
    var id: Int = 0,
    var user: String = "",
    var name: String = "",
    var email: String = ""
)
