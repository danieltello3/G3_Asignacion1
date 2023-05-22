package pe.edu.grupo3_asignacion1.services

import pe.edu.grupo3_asignacion1.models.User

class UserService {
    companion object {
        var users = mutableListOf(
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

        fun create(usuario: String, contrasenia: String,correo: String): Int{
            val listSize = users.size
            val imagen = "https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/"+(listSize-1)+".png"
            val user = User(listSize+1,usuario,contrasenia,usuario,correo,imagen)
            users.add(listSize,user)
            return listSize

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

        fun verifyIfEmailAlreadyExists(correo: String): Boolean {
            var flag = false
            for (u in users){
                if(u.correo == correo){
                    flag = true
                    break
                }
            }
            return flag
        }

        fun verifyIfUserAlreadyExists(usuario:String): Boolean {
            var flag = false
            for (u in users) {
                if (u.usuario == usuario) {
                    flag = true
                    break
                }
            }
            return flag
        }
    }
}