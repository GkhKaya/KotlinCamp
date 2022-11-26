package com.example.fragmentexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragmentfirst.view.*

class FragmentFirst : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView = inflater.inflate(R.layout.fragmentfirst,container,false)

        rootView.buttonClick.setOnClickListener {
            Toast.makeText(activity,"Hello",Toast.LENGTH_SHORT).show()
        }

        return rootView
    }
}