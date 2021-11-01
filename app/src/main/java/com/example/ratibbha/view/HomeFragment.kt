package com.example.ratibbha.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ratibbha.R
import com.example.ratibbha.database.model.CardModel
import com.google.android.material.floatingactionbutton.FloatingActionButton


class HomeFragment : Fragment() {


    private val taskList = mutableListOf<CardModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val taskRecyclerView:RecyclerView = view.findViewById(R.id.recyclerView)
        val addFloatingActionButton: FloatingActionButton = view.findViewById(R.id.floatingActionButton_home)



    }

}