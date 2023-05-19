package pe.edu.grupo3_asignacion1.models

data class User (
    var id: Int = 0,
    var usuario: String = "",
    var contrasenia: String = "",
    var nombre: String = "",
    var correo: String = "",
    var imagen: String = "",
)
