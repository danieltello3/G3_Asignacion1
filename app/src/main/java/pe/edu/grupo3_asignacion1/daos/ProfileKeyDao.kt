package pe.edu.grupo3_asignacion1.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import pe.edu.grupo3_asignacion1.models.ProfileKey

@Dao
interface ProfileKeyDao {
    @Insert
    fun setFirstLoad(profileKey: ProfileKey)

    @Query("SELECT * FROM profile_keys WHERE user_id = :userId")
    fun getProfileUserById(userId: Int): ProfileKey?

    @Query("DELETE from profile_keys")
    fun deleteAllProfileKeys()
}