package com.example.usenavigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_game_screen.view.*


class GameScreenFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val design  =inflater.inflate(R.layout.fragment_game_screen, container, false)

        design.finishButton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.switchingResultScreen)
        }

        return design
    }

    }
