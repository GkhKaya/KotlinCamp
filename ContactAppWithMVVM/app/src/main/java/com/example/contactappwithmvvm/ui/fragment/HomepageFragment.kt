package com.example.contactappwithmvvm.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contactappwithmvvm.R
import com.example.contactappwithmvvm.data.entity.Contacts
import com.example.contactappwithmvvm.databinding.FragmentHomepageBinding
import com.example.contactappwithmvvm.ui.adapter.ContactAdapter
import com.example.contactappwithmvvm.ui.vievmodel.AddContactViewModel
import com.example.contactappwithmvvm.ui.vievmodel.HomepageViewModel
import com.example.contactappwithmvvm.util.doTransition
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomepageFragment : Fragment(),SearchView.OnQueryTextListener {
    private lateinit var design:FragmentHomepageBinding
    private lateinit var viewModel:HomepageViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        design = DataBindingUtil.inflate(inflater,R.layout.fragment_homepage, container, false)
        design.homepageFragment = this
        design.homepageToolbarTitle = "Contact"
        (activity as AppCompatActivity).setSupportActionBar(design.toolbarHomepage)

        viewModel.contactList.observe(viewLifecycleOwner){
            val adapter  =ContactAdapter(requireContext(),it,viewModel)
            design.contactAdapter = adapter
        }



        requireActivity().addMenuProvider(object :MenuProvider{
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.toolbar_menu,menu)

                val item = menu.findItem(R.id.action_search)
                val searcView = item.actionView as SearchView
                searcView.setOnQueryTextListener(this@HomepageFragment)

            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return false
            }
        },viewLifecycleOwner,Lifecycle.State.RESUMED)


        return design.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : HomepageViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun fabClick(it:View){
        Navigation.doTransition(R.id.addContactTransition,it)
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        search(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        search(newText)
        return true
    }

    fun search(searchedWord:String){
        viewModel.search(searchedWord)
    }


}