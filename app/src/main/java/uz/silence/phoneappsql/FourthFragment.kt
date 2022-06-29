package uz.silence.phoneappsql

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import uz.silence.phoneappsql.Adapters.RvFirstAdapter
import uz.silence.phoneappsql.Adapters.RvSecondAdapter
import uz.silence.phoneappsql.CLASS.FirstClass
import uz.silence.phoneappsql.CLASS.Phone
import uz.silence.phoneappsql.DB.MyDbHelper
import uz.silence.phoneappsql.databinding.FragmentThirdBinding

class FourthFragment : Fragment() {

    private var _binding: FragmentThirdBinding? = null
    private val binding get() = _binding!!

    lateinit var myDbHelper: MyDbHelper
    lateinit var list: ArrayList<Phone>
    lateinit var rvSecondAdapter: RvSecondAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        _binding = FragmentThirdBinding.inflate(inflater, container, false)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val type = arguments?.getInt("b")

        Toast.makeText(context, "$type", Toast.LENGTH_SHORT).show()

        myDbHelper = MyDbHelper(context!!)

        val allPhone = myDbHelper.getAllPhone()
        list = ArrayList()

        for (i in 0 until allPhone.size){

            if (allPhone[i].type == type){
                list.add(allPhone[i])
            }

        }


        rvSecondAdapter = RvSecondAdapter(list,object : RvSecondAdapter.OnItemClickListener{
            override fun onItemContactClick(phone: Phone, position: Int) {

                val bundle = Bundle()

                bundle.putInt("wow", phone.id!!)

                findNavController().navigate(R.id.fifthFragment,bundle)
            }
        })

        binding.rvThird.adapter = rvSecondAdapter

    }


}