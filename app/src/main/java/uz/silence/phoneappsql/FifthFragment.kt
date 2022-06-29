package uz.silence.phoneappsql

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.silence.phoneappsql.CLASS.Phone
import uz.silence.phoneappsql.DB.MyDbHelper
import uz.silence.phoneappsql.databinding.FragmentFifthBinding
import uz.silence.phoneappsql.databinding.FragmentFirstBinding
import uz.silence.phoneappsql.databinding.FragmentThirdBinding

class FifthFragment : Fragment() {

    private var _binding: FragmentFifthBinding? = null
    private val binding get() = _binding!!

    lateinit var myDbHelper: MyDbHelper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFifthBinding.inflate(inflater, container, false)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myDbHelper = MyDbHelper(context!!)

        val WoW = arguments?.getInt("wow", -1)

        binding.infoTv.text = myDbHelper.getPhoneById(WoW!!).info


    }


}