package corner.z.kottodo.data

import androidx.lifecycle.LiveData

class RepToDo(private val daoToDo: DaoToDo) {
    val lstAllToDo: LiveData<List<ToDo>> = daoToDo.readAll()
    suspend fun addToDo(toDo: ToDo){
        daoToDo.add(toDo)
    }

    suspend fun updateToDo(toDo: ToDo){
        daoToDo.update(toDo)
    }
}