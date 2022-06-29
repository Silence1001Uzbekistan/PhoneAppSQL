package uz.silence.phoneappsql.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import uz.silence.phoneappsql.CLASS.FirstClass
import uz.silence.phoneappsql.databinding.FirstItemBinding

class RvFirstAdapter(
    var list: ArrayList<FirstClass>,
    var onItemClickListener: OnItemClickListener
) : RecyclerView.Adapter<RvFirstAdapter.Vh>() {

    inner class Vh(var firstItemBinding: FirstItemBinding) :
        RecyclerView.ViewHolder(firstItemBinding.root) {


        fun onBind(firstClass: FirstClass, position: Int) {

            firstItemBinding.firstTextId.text = firstClass.nameFirst

            firstItemBinding.root.setOnClickListener {
                onItemClickListener.onItemContactClick(firstClass, position)
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

        fun onItemContactClick(firstClass: FirstClass, position: Int)

    }

}