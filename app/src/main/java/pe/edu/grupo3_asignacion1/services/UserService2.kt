package pe.edu.grupo3_asignacion1.services

import pe.edu.grupo3_asignacion1.models.User

class UserService2 {
    companion object {
        var users = mutableListOf(
            User (1, "admin","123", "Super Administrador", "root@ulima.edu.pe", "https://images.pexels.com/photos/5119214/pexels-photo-5119214.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"),
            User (2, "pepe","123", "Pepe Valdivia", "pepe@ulima.edu.pe", "https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/2.png"),
            User (3, "sila","123", "Sila Esculapia", "sila@ulima.edu.pe", "https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/3.png"),
            User (4, "mateo","123", "Mateo Sanchez", "mateo@ulima.edu.pe", "https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/4.png"),
            User (5, "marcos","123", "Marcos Perez", "marcos@ulima.edu.pe", "https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/5.png"),
            User (6, "lucas","123", "Lucas Moura", "lucas@ulima.edu.pe", "https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/6.png"),
            User (7, "juan","123", "Juan Vargas", "juan@ulima.edu.pe", "https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/7.png"),
            User (8, "judas","123", "Judas Iscariote", "judas@ulima.edu.pe", "https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/8.png"),
            User (9, "tito","123", "Tito Garcia", "tito@ulima.edu.pe", "https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/9.png"),
            User (10, "filemon","123", "Filemon Peluche", "filemon@ulima.edu.pe", "https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/10.png"),
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

            val imagen:String = "https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/"+(listSize-1)+".png"
            val user = User(listSize+1,usuario,contrasenia,usuario,correo,imagen)
            users.add(listSize,user)
            return listSize+1

        }

        fun fetchOne(id: Int): User {
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

        fun verifyIfEmailAlreadyExists(correo: String): Boolean {
            var flag:Boolean = false
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

        fun updateUser(id:Int, name: String,user:String,mail:String){
            val userTemp = users.find{it.id == id}
            userTemp?.correo = mail
            userTemp?.nombre = name
            userTemp?.usuario = user
        }

        fun updatePassword(id:Int, password: String){
            val userTemp = users.find{it.id == id}
            userTemp?.contrasenia = password
        }
    }
}
