package pe.edu.grupo3_asignacion1.services

import androidx.compose.ui.text.toLowerCase
import pe.edu.grupo3_asignacion1.models.User

class UserService {
    companion object {
        val users = listOf(
            User (1, "admin","123", "Super Administrador", "root@ulima.edu.pe", "https://images.pexels.com/photos/5119214/pexels-photo-5119214.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"),
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

        fun existData(mail: String, user: String,id: Int): String{
            var message = "OK"
            for(u in users){
                if(u.id != id && u.usuario == user){
                    message = "Usuario se encuentra en uso"
                }
                if(u.id != id && u.correo == mail){
                    message = "Correo se encuentra en uso"
                }
            }
            return message
        }

        fun validatePassword(id:Int, password:String): Boolean{
            var response:Boolean = false
            for(u in users){
                if(u.id == id && u.contrasenia == password){
                    response = true
                }
            }
            return response
        }
    }
}