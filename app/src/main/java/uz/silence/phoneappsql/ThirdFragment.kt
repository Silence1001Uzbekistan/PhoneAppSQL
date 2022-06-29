package uz.silence.phoneappsql

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import uz.silence.phoneappsql.Adapters.RvFirstAdapter
import uz.silence.phoneappsql.CLASS.FirstClass
import uz.silence.phoneappsql.databinding.FragmentHomeBinding
import uz.silence.phoneappsql.databinding.FragmentThirdBinding


class ThirdFragment : Fragment() {

    private var _binding: FragmentThirdBinding? = null
    private val binding get() = _binding!!

    lateinit var list: ArrayList<FirstClass>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        _binding = FragmentThirdBinding.inflate(inflater, container, false)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        list = ArrayList()

        list.add(FirstClass("Iphone"))
        list.add(FirstClass("Samsung"))
        list.add(FirstClass("MI"))
        list.add(FirstClass("Sony"))
        list.add(FirstClass("Huawei"))
        list.add(FirstClass("Artel"))


        val rvFirstAdapter = RvFirstAdapter(list, object : RvFirstAdapter.OnItemClickListener {
            override fun onItemContactClick(firstClass: FirstClass, position: Int) {

                val bundle = Bundle()
                bundle.putInt("b",position)

                findNavController().navigate(R.id.fourthFragment,bundle)
            }
        })

        binding.rvThird.adapter = rvFirstAdapter


    }


}