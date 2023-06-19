package pe.edu.grupo3_asignacion1.daos

import androidx.room.*
import pe.edu.grupo3_asignacion1.models.Photo

interface PhotoDao {
    @Insert
    fun insertMany(pokemon: List<Photo>)

    @Query("SELECT * FROM photos")
    suspend fun getPhotos(): List<Photo>

    @Query("DELETE FROM photos")
    fun deleteAllPhotos()

    @Query("SELECT * FROM photos WHERE id = :id")
    suspend fun getPhotosById(id: Int): Photo?

    @Query("DELETE FROM photos WHERE id = :id")
    suspend fun deletePhotosById(id: Int): Unit
}