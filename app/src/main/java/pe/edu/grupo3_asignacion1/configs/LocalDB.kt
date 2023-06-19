package pe.edu.ulima.dbaccess.configs

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import pe.edu.grupo3_asignacion1.daos.UserDao
import pe.edu.grupo3_asignacion1.models.User
import java.io.File

@Database(
    entities = [
        User::class,
    ],
    version = 1,
    exportSchema = false
)
abstract class LocalDB: RoomDatabase() {
    // daos
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
                    ).createFromAsset("database/test.db").build()
                }
            }
            return INSTANCE!!
        }
    }
}