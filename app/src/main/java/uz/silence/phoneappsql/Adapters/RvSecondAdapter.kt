package uz.silence.phoneappsql.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.silence.phoneappsql.CLASS.FirstClass
import uz.silence.phoneappsql.CLASS.Phone
import uz.silence.phoneappsql.databinding.FirstItemBinding

class RvSecondAdapter(
    var list: ArrayList<Phone>,
    var onItemClickListener: OnItemClickListener
) : RecyclerView.Adapter<RvSecondAdapter.Vh>() {

    inner class Vh(var firstItemBinding: FirstItemBinding) :
        RecyclerView.ViewHolder(firstItemBinding.root) {


        fun onBind(phone: Phone, position: Int) {

            firstItemBinding.firstTextId.text = phone.name

            firstItemBinding.root.setOnClickListener {
                onItemClickListener.onItemContactClick(phone, position)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(FirstItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface OnItemClickListener {

        fun onItemContactClick(phone: Phone, position: Int)

    }

}