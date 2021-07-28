package corner.z.kottodo.data.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import corner.z.kottodo.data.model.ToDo
import corner.z.kottodo.data.db.DbToDo
import corner.z.kottodo.data.repo.RepToDo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class VmToDo(application: Application): AndroidViewModel(application) {
    val lstAllToDo: LiveData<List<ToDo>>
    private val repo: RepToDo

    init{
        val daoToDo = DbToDo.getDb(application).daoToDo()
        repo = RepToDo(daoToDo)
        lstAllToDo = repo.lstAllToDo
    }

    fun addToDo(toDo: ToDo){
        viewModelScope.launch(Dispatchers.IO){
            repo.addToDo(toDo)
        }
    }

    fun updateToDo(toDo: ToDo) {
        viewModelScope.launch(Dispatchers.IO){
            repo.updateToDo(toDo)
        }
    }
}