package corner.z.kottodo.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ToDo::class], version = 1, exportSchema = false)
abstract class DbToDo: RoomDatabase() {
    abstract fun daoToDo(): DaoToDo

    companion object{
        @Volatile
        private var INSTANCE: DbToDo? = null

        fun getDb(ctx: Context): DbToDo {
            val tmpINSTANCE = INSTANCE
            if(tmpINSTANCE != null)
                return tmpINSTANCE;

            synchronized(this){
                val newINSTANCE = Room.databaseBuilder(
                    ctx.applicationContext,
                    DbToDo::class.java,
                    "DbToDo"
                ).build()

                INSTANCE = newINSTANCE
                return newINSTANCE
            }
        }
    }
}