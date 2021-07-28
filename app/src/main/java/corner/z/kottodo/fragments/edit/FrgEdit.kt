package corner.z.kottodo.fragments.edit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import corner.z.kottodo.R
import corner.z.kottodo.data.model.ToDo
import corner.z.kottodo.data.viewmodel.VmToDo
import kotlinx.android.synthetic.main.fragment_frg_edit.*
import kotlinx.android.synthetic.main.fragment_frg_edit.view.*

class FrgEdit : Fragment() {
    private val args by navArgs<FrgEditArgs>()
    private lateinit var vmToDo: VmToDo
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_frg_edit, container, false)
        view.etToDo.setText(args.curToDo.strToDo)

        vmToDo = ViewModelProvider(this).get(VmToDo::class.java)
        view.btnSave.setOnClickListener {
            updateToDo()
        }

        return view
    }

    private fun updateToDo(){
        val tmpStrToDo = etToDo.text.toString()

        if(tmpStrToDo.isNotEmpty()) {
            val tmpToDoUpdated = ToDo(args.curToDo.id, args.curToDo.bDone, tmpStrToDo)
            vmToDo.updateToDo(tmpToDoUpdated)
            Toast.makeText(requireContext(),"Successfully updated!", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_frgEdit_to_frgList)
        } else {
            Toast.makeText(requireContext(),"Update fails!", Toast.LENGTH_SHORT).show()
        }
    }
}