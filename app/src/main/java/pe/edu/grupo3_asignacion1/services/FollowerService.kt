package pe.edu.grupo3_asignacion1.services

import pe.edu.grupo3_asignacion1.models.Follows
import pe.edu.grupo3_asignacion1.models.User

class FollowerService {
    companion object {
        fun fetchAll(): List<Follows> {
            return listOf(
                Follows (1,1,2),
                Follows (2,1,3),
                Follows (3,1,4),
                Follows (4,1,5),
                Follows (5,1,6),
                Follows (6,1,7),
                Follows (7,2,1),
                Follows (8,2,4),
                Follows (9,2,5),
                Follows (10,2,6),
                Follows (11,2,7),
                Follows (12,3,1),
                Follows (13,3,2),
                Follows (14,3,4),
                Follows (15,3,10),
                Follows (16,4,8),
                Follows (17,4,9),
                Follows (18,4,10),
                Follows (19,4,1),
                Follows (20,5,1),
                Follows (21,5,2),
                Follows (22,5,3),
                Follows (23,5,4),
                Follows (24,5,6),
                Follows (25,5,7),
                Follows (26,5,8),
                Follows (27,5,9),
                Follows (28,5,10),
                Follows (29,6,1),
                Follows (30,6,7),
                Follows (31,6,3),
                Follows (32,6,10),
                Follows (33,7,1),
                Follows (34,7,3),
                Follows (35,7,6),
                Follows (36,7,8),
                Follows (37,7,9),
                Follows (38,8,1),
                Follows (39,8,2),
                Follows (40,8,3),
                Follows (41,8,4),
                Follows (42,9,5),
                Follows (43,9,6),
                Follows (44,10,1),
            )
        }

        fun countFollowingsByUserId(userId: Int): Int{
            var respuesta : Int = 0
            val list: List<Follows> = fetchAll()
            for(following in list){
                if(following.usuarioId == userId){
                    respuesta = respuesta + 1
                }
            }
            return respuesta
        }

        fun countFollowersBySeId(userId: Int): Int{
            var respuesta : Int = 0
            val list: List<Follows> = fetchAll()
            for(follower in list){
                if(follower.seguidorId == userId){
                    respuesta = respuesta + 1
                }
            }
            return respuesta
        }

        fun fetchFollowers(userId: Int): List<User>{
            val respuesta : MutableList<User> = arrayListOf()
            val list: List<Follows> = FollowerService.fetchAll()
            for(follower in list){
                if(follower.usuarioId == userId){
                    val seguidor: User = UserService.fetchOne(follower.seguidorId)
                    respuesta.add(seguidor)
                }
            }
            return respuesta
        }
        fun fetchFollowings(userId: Int): List<User>{
            val respuesta : MutableList<User> = arrayListOf()
            val list: List<Follows> = FollowerService.fetchAll()
            for(following in list){
                if(following.seguidorId == userId){
                    val seguidor: User = UserService.fetchOne(following.usuarioId)
                    respuesta.add(seguidor)
                }
            }
            return respuesta
        }
    }
}