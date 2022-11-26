package com.example.usenavigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_main.view.*


class MainFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val design = inflater.inflate(R.layout.fragment_main, container, false)

        design.startButton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.switchingToGameScreen)
        }

        return design
    }}


