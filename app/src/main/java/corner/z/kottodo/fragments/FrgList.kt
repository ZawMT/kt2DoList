package corner.z.kottodo.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import corner.z.kottodo.R
import corner.z.kottodo.adaptor.AdptrRvToDo
import corner.z.kottodo.data.VmToDo
import kotlinx.android.synthetic.main.fragment_frg_list.view.*

class FrgList : Fragment() {
    private lateinit var vmToDo: VmToDo

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vwTmp = inflater.inflate(R.layout.fragment_frg_list, container, false)

        val tmpAdptr = AdptrRvToDo()
        val tmpRv = vwTmp.rvListTodo
        tmpRv.adapter = tmpAdptr
        tmpRv.layoutManager = LinearLayoutManager(requireContext())

        vmToDo = ViewModelProvider(this).get(VmToDo::class.java)
        vmToDo.lstAllToDo.observe(viewLifecycleOwner, Observer { toDo ->
            tmpAdptr.setData(toDo)
        })

        vwTmp.fabAdd.setOnClickListener{
            findNavController().navigate(R.id.action_frgList_to_frgAdd)
        }

        return vwTmp
    }
}