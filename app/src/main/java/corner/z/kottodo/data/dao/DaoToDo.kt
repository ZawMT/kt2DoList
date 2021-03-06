package corner.z.kottodo.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import corner.z.kottodo.data.model.ToDo

@Dao
interface DaoToDo {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun add(toDo: ToDo)

    @Query("SELECT * FROM TToDo ORDER BY id")
    fun readAll(): LiveData<List<ToDo>>

    @Update
    suspend fun update(toDo: ToDo)

    @Delete
    suspend fun delete(toDo: ToDo)
}