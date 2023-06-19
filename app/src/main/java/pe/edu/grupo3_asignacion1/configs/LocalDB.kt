package pe.edu.grupo3_asignacion1.configs

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import pe.edu.grupo3_asignacion1.daos.PhotoDao
import pe.edu.grupo3_asignacion1.daos.ProfileKeyDao
import pe.edu.grupo3_asignacion1.daos.UserDao
import pe.edu.grupo3_asignacion1.models.Photo
import pe.edu.grupo3_asignacion1.models.ProfileKey
import pe.edu.grupo3_asignacion1.models.User

@Database(
    entities = [
        Photo::class,
        User::class,
        ProfileKey::class,
    ],
    version = 1,
    exportSchema = false
)
abstract class LocalDB: RoomDatabase() {
    // daos
    abstract fun photoDao(): PhotoDao
    abstract fun profileKeyDao(): ProfileKeyDao
    abstract fun userDao(): UserDao

    companion object{
        private var INSTANCE: LocalDB ?= null

        fun getDatabase(context: Context): LocalDB{
            if(INSTANCE == null){
                synchronized(LocalDB::class){
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        LocalDB::class.java,
                        "local_db"
                    ).build()
                }
            }
            return INSTANCE!!
        }
    }
}