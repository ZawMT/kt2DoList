package corner.z.kottodo.data.repo

import androidx.lifecycle.LiveData
import corner.z.kottodo.data.dao.DaoToDo
import corner.z.kottodo.data.model.ToDo

class RepToDo(private val daoToDo: DaoToDo) {
    val lstAllToDo: LiveData<List<ToDo>> = daoToDo.readAll()
    suspend fun addToDo(toDo: ToDo){
        daoToDo.add(toDo)
    }

    suspend fun updateToDo(toDo: ToDo){
        daoToDo.update(toDo)
    }
}