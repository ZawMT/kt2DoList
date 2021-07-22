package corner.z.kottodo.fragments

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import corner.z.kottodo.R
import corner.z.kottodo.data.ToDo
import corner.z.kottodo.data.VmToDo
import kotlinx.android.synthetic.main.fragment_frg_add.*
import kotlinx.android.synthetic.main.fragment_frg_add.view.*

class FrgAdd : Fragment() {
    private lateinit var vmToDo: VmToDo

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vwTmp = inflater.inflate(R.layout.fragment_frg_add, container, false)

        vmToDo = ViewModelProvider(this).get(VmToDo::class.java)
        vwTmp.btnAdd.setOnClickListener {
            insertToDo()
        }

        return vwTmp
    }

    private fun insertToDo() {
        val strToDo = etToDo.text.toString()
        if(!TextUtils.isEmpty(strToDo)){
            val tmpToDo = ToDo(0, false, strToDo)
            vmToDo.addToDo(tmpToDo)
            Toast.makeText(requireContext(), "The new TODO added", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_frgAdd_to_frgList)

        } else {
            Toast.makeText(requireContext(), "Problem to add TODO", Toast.LENGTH_LONG).show()
        }
    }
}