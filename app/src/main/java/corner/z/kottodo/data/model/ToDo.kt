package corner.z.kottodo.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "TToDo")
data class ToDo (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val strToDo: String,
    var bDone: Boolean = false,
    var bToDelete: Boolean = false
): Parcelable