package com.example.usenavigationcomponent

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_game_screen.view.*


class GameScreenFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val design  =inflater.inflate(R.layout.fragment_game_screen, container, false)

        val bundle:GameScreenFragmentArgs by navArgs()

        val incomingName = bundle.name
        val incomingAge = bundle.age
        val incomingHeight = bundle.height
        val incomingIsSingle = bundle.isSingle
        val incomingObject  =bundle.object


        Log.e("incoming Name",incomingName)
        Log.e("incoming Age",incomingAge.toString())
        Log.e("incoming Height",incomingHeight.toString())
        Log.e("incoming Single İnformation",incomingIsSingle.toString())
        Log.e("incoming User No",incomingObject.user_no.toString())
        Log.e("incoming User Name",incomingObject.user_name)

        design.finishButton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.switchingResultScreen)
        }

        return design
    }

    }
