package pe.edu.grupo3_asignacion1.models.responses

import pe.edu.grupo3_asignacion1.models.User

data class UpdateResponse(
    val status: String,
    val message: String,
    val data: User
)
