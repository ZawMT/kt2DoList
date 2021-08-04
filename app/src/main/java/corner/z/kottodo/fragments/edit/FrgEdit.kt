package corner.z.kottodo.fragments.edit

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
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
        if(args.curToDo.bToDelete) {
            deleteToDo(true)
        }

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_frg_edit, container, false)
        view.etToDo.setText(args.curToDo.strToDo)

        vmToDo = ViewModelProvider(this).get(VmToDo::class.java)
        view.btnSave.setOnClickListener {
            updateToDo()
        }

        setHasOptionsMenu(true)

        return view
    }

    private fun updateToDo(){
        val tmpStrToDo = etToDo.text.toString()

        if(tmpStrToDo.isNotEmpty()) {
            val tmpToDoUpdated = ToDo(args.curToDo.id, tmpStrToDo, args.curToDo.bDone)
            vmToDo.updateToDo(tmpToDoUpdated)
            Toast.makeText(requireContext(),"Successfully updated!", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_frgEdit_to_frgList)
        } else {
            Toast.makeText(requireContext(),"Update fails!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_delete, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.menu_item_delete) {
            deleteToDo(false)
        }

        return super.onOptionsItemSelected(item)
    }

    private fun deleteToDo(bReturnToList: Boolean){
        val adBuilder = AlertDialog.Builder(requireContext())
        adBuilder.setPositiveButton("Yes"){ _, _ ->
            vmToDo.deleteToDo(args.curToDo)
            Toast.makeText(requireContext(), "Successfully deleted!", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_frgEdit_to_frgList)
        }
        adBuilder.setNegativeButton("No"){ _, _ ->
            if(bReturnToList) {
                findNavController().navigate(R.id.action_frgEdit_to_frgList)
            }
        }
        adBuilder.setTitle("Confirm to delete the following ToDo?")
        adBuilder.setMessage("${args.curToDo.strToDo}")
        adBuilder.show()
    }
}