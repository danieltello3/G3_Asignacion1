package pe.edu.grupo3_asignacion1.services

import pe.edu.grupo3_asignacion1.models.demo.FollowList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FollowerService{
    @GET("/user/follower")
    fun fetchFollower (
        @Query("user_id") user_id: Int
    ): Call<FollowList>
    @GET("/user/following")
    fun fetchFollowing (
        @Query("user_id") user_id: Int
    ): Call<FollowList>
}