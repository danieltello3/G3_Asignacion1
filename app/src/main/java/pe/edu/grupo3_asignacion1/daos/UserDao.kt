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

    @Query("SELECT * FROM users WHERE id= :id")
    abstract fun get(id: Int): User?

    @Query("SELECT COUNT(*) FROM users WHERE id=:id AND password=:password")
    fun validatePassword(id: Int, password: String): Int

    @Query("SELECT * FROM users WHERE id<>:id AND (user=:user OR email=:email)")
    fun validateUser(id: Int, user: String, email: String): User?

    @Query("UPDATE users SET user=:user, name=:name, email=:email WHERE id=:id")
    fun update(id: Int, user: String, name: String, email: String): Int

    @Query("UPDATE users SET password=:password WHERE id=:id")
    fun updatePassword(id: Int, password: String): Int
}