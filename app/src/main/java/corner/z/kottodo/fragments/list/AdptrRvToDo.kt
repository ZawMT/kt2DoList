package corner.z.kottodo.fragments.list

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import corner.z.kottodo.R
import corner.z.kottodo.data.model.ToDo
import corner.z.kottodo.data.viewmodel.VmToDo
import kotlinx.android.synthetic.main.row_todo.view.*

class AdptrRvToDo: RecyclerView.Adapter<AdptrRvToDo.VhLstToDo>() {
    private var lstToDo = emptyList<ToDo>()

    class VhLstToDo(itemView: View): RecyclerView.ViewHolder(itemView){
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VhLstToDo {
        return VhLstToDo(LayoutInflater.from(parent.context).inflate(R.layout.row_todo, parent, false))
    }

    override fun onBindViewHolder(holder: VhLstToDo, position: Int) {
        val tmpCur = lstToDo[position]
        holder.itemView.tvTodo.text = tmpCur.strToDo
        holder.itemView.cbDone.isChecked = tmpCur.bDone

        holder.itemView.row_todo_layout.setOnClickListener {
            val tmpAction = FrgListDirections.actionFrgListToFrgEdit(tmpCur)
            holder.itemView.findNavController().navigate(tmpAction)
        }

        holder.itemView.row_todo_layout.btnDel.setOnClickListener {
            tmpCur.bToDelete = true
            val tmpAction = FrgListDirections.actionFrgListToFrgEdit(tmpCur)
            holder.itemView.findNavController().navigate(tmpAction)
        }
    }

    override fun getItemCount(): Int {
        return lstToDo.size
    }

    fun setData(lstToDo: List<ToDo>){
        this.lstToDo = lstToDo
        notifyDataSetChanged()
    }
}