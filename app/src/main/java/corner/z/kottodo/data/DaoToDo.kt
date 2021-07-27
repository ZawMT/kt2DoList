package corner.z.kottodo.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface DaoToDo {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun add(toDo: ToDo)

    @Query("SELECT * FROM TToDo ORDER BY id")
    fun readAll(): LiveData<List<ToDo>>

    @Update
    suspend fun update(toDo: ToDo)
}