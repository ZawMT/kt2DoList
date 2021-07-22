package corner.z.kottodo.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TToDo")
data class ToDo(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    var bDone: Boolean = false,
    val strToDo: String
)