package com.example.myapplication.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.myapplication.FirstItem
import com.example.myapplication.R
import com.example.myapplication.RVItemType
import com.example.myapplication.SecondItem

class MainFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var rvAdapter: RVAdapter
    private lateinit var multipleViewAdapter: MultipleLayoutAdapter

    private var singleTypeItem = arrayListOf<String>()
    private var multipleViewTypeItem = arrayListOf<RVItemType>()

    init {
        singleTypeItem.apply {
            for(i in 0..29) add((i+1).toString())
        }
        multipleViewTypeItem.apply {
            for(i in 0..19) add(FirstItem((i+1).toString()))
            for(i in 0..19) add(SecondItem((i+20).toString()))
        }
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerView)
        rvAdapter = RVAdapter(singleTypeItem)
        multipleViewAdapter = MultipleLayoutAdapter(multipleViewTypeItem)
        recyclerView.layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
//        recyclerView.adapter = rvAdapter
        recyclerView.adapter = multipleViewAdapter
    }



    companion object {
        fun newInstance() = MainFragment()
    }
}