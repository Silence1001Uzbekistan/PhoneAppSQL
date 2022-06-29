package uz.silence.phoneappsql

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import uz.silence.phoneappsql.CLASS.Phone
import uz.silence.phoneappsql.DB.MyDbHelper
import uz.silence.phoneappsql.databinding.FragmentFirstBinding
import uz.silence.phoneappsql.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    lateinit var myDbHelper: MyDbHelper
    lateinit var list: ArrayList<Phone>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val type = arguments?.getInt("a")

        Toast.makeText(context, "$type", Toast.LENGTH_SHORT).show()

        myDbHelper = MyDbHelper(context!!)

        binding.btnSave.setOnClickListener {

            if (binding.editPhoneName.text.trim().isNotEmpty() && binding.editFeatures.text.trim().isNotEmpty()){

                val text = binding.editPhoneName.text.toString()
                val text1 = binding.editFeatures.text.toString()

                val phone = Phone(type, text, text1)

                myDbHelper.addPhone(phone)
                findNavController().navigate(R.id.homeFragment)
                val allPhone = myDbHelper.getAllPhone()

                for (i in 0 until allPhone.size){
                    Toast.makeText(context, "${allPhone[i].name}", Toast.LENGTH_SHORT).show()
                }

            }


        }

    }

}