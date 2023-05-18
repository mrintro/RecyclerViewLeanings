package com.example.myapplication.ui.main

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class RVAdapter(
    var items: List<String> = emptyList()
) : RecyclerView.Adapter<RVViewHolder>() {

    private var counter = 0
    private var Tag = "RV Adapter"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVViewHolder {
        Log.d(Tag, "Creating View Holder $counter")
        counter++
        return RVViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.rv_tile_card, parent, false)
        )
    }
    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RVViewHolder, position: Int) {
        Log.d(Tag, "Binding View Holder $position")
        holder.bind(items[position]) {
            updateCount(position)
        }
    }

    fun updateCount(position: Int) {
        items = items.toMutableList().apply {
            this[position] = (this[position].toInt() + 1).toString()
            toList()
        }
//        notifyDataSetChanged()
        notifyItemChanged(position)
    }

}

class RVViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    lateinit var textView: TextView
    fun bind(item: String, clickEvent: () -> Unit) {
        textView = (view).findViewById(R.id.dummyText)
        textView.text = item
        textView.setOnClickListener{
            clickEvent()
        }
    }
}
