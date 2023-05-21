package pe.edu.grupo3_asignacion1.services

import pe.edu.grupo3_asignacion1.models.User

class UserService {
    companion object {
        val users = listOf(
            User (1, "admin","123", "Super Administrador", "root@ulima.edu.pe", "https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/1.png"),
            User (2, "pepe","123", "Pepe Valdivia", "pepe@ulima.edu.pe", "https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/2.png"),
            User (3, "sila","123", "Sila Esculapia", "sila@ulima.edu.pe", "https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/3.png"),
            User (4, "mateo","123", "Mateo Sanchez", "mateo@ulima.edu.pe", "https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/4.png"),
            User (5, "marcos","123", "Marcos Perez", "marcos@ulima.edu.pe", "https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/5.png"),
            User (6, "lucas","123", "Lucas Moura", "lucas@ulima.edu.pe", "https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/6.png"),
            User (7, "juan","123", "Juan Vargas", "juan@ulima.edu.pe", "https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/7.png"),
            User (8, "judas","123", "Judas Iscariote", "judas@ulima.edu.pe", "https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/8.png"),
            User (9, "tito","123", "Tito Garcia", "tito@ulima.edu.pe", "https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/9.png"),
            User (10, "filemon","123", "Filemon Peluche", "filemon@ulima.edu.pe", "https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/9.png"),
        )

        fun validate(usuario: String, contrasenia: String): Int {
            var id = 0
            for(u in users){
                if(u.usuario == usuario && u.contrasenia == contrasenia){
                    id = u.id
                }
            }
            return id
        }

        fun fetchOne(id: Int): User{
            var user = User()
            for(u in users){
                if(u.id == id){
                    user = u
                }
            }
            return user
        }
    }
}