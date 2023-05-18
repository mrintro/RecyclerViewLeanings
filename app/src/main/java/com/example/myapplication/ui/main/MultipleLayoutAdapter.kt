package com.example.myapplication.ui.main

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.FirstItem
import com.example.myapplication.R
import com.example.myapplication.RVItemType
import com.example.myapplication.SecondItem

class MultipleLayoutAdapter(
    var items: List<RVItemType> = emptyList()
) : RecyclerView.Adapter<MultipleRVViewHolder>() {

    private var counter = 0
    private var Tag = "RV Adapter"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MultipleRVViewHolder {
        Log.d(Tag, "Creating View Holder $counter")
        counter++
        return MultipleRVViewHolder(
            LayoutInflater.from(parent.context).inflate(getLayoutType(viewType), parent, false)
        )
    }

    fun getLayoutType(viewType: Int) : Int = when(viewType){
        1 -> R.layout.rv_tile_card
        2 -> R.layout.rv_tile_second_card
        else -> throw java.lang.IllegalArgumentException("Exception")
    }

    override fun getItemViewType(position: Int): Int = items[position].getItemType()

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: MultipleRVViewHolder, position: Int) {
        Log.d(Tag, "Binding View Holder $position")
        holder.bind(items[position]) {
//            updateCount(position)
        }
    }

//    fun updateCount(position: Int) {
//        items = items.toMutableList().apply {
//            this[position] = (this[position].toInt() + 1).toString()
//            toList()
//        }
////        notifyDataSetChanged()
//        notifyItemChanged(position)
//    }


}

class MultipleRVViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    lateinit var textView: TextView
    lateinit var textView2: TextView
    lateinit var textView3: TextView
    fun bind(item: RVItemType, clickEvent: () -> Unit) {
        when(item) {
            is FirstItem -> bindFirstItemType(item)
            is SecondItem -> bindSecondItemType(item)
        }
    }
    fun bindFirstItemType(item: FirstItem) {
        textView = view.findViewById(R.id.dummyText)
        textView.text = item.text
    }
    fun bindSecondItemType(item: SecondItem) {
        textView2 = view.findViewById(R.id.dummyText1)
        textView3 = view.findViewById(R.id.dummyText2)
        textView2.text = item.text
        textView3.text = "Repeat ${item.text}"
    }


}