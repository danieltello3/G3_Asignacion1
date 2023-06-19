package pe.edu.grupo3_asignacion1.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import pe.edu.grupo3_asignacion1.models.beans.User

@Dao
interface UserDao {
    @Insert //Room: libreria para sqlite, manejo de escritura en la bd local
    fun insert(user: User)

    @Query("DELETE FROM users")
    fun deleteAll()

    @Query("SELECT COUNT(*) FROM users")
    suspend fun getUserCount(): Int

    @Query("SELECT * FROM users LIMIT 1")
    suspend fun getUser(): User?



}