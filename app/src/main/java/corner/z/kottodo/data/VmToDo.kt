package corner.z.kottodo.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class VmToDo(application: Application): AndroidViewModel(application) {
    private val lstAllToDo: LiveData<List<ToDo>>
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
}