package pe.edu.grupo3_asignacion1.daos

import androidx.room.*
import pe.edu.grupo3_asignacion1.models.User

@Dao
interface UserDao {
    @Insert
    fun insert(user: User)

    @Query("DELETE FROM users")
    fun deleteAll()

    @Query("SELECT COUNT(*) FROM users")
    suspend fun getUserCount(): Int

    @Query("SELECT * FROM users LIMIT 1")
    suspend fun getUser(): User?
}