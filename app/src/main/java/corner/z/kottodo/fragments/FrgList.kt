package corner.z.kottodo.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import corner.z.kottodo.R
import kotlinx.android.synthetic.main.fragment_frg_list.view.*

class FrgList : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vwTmp = inflater.inflate(R.layout.fragment_frg_list, container, false)
        vwTmp.fabAdd.setOnClickListener{
            findNavController().navigate(R.id.action_frgList_to_frgAdd)
        }

        return vwTmp
    }
}