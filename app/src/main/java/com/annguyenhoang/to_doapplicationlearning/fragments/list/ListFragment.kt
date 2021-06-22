package com.annguyenhoang.to_doapplicationlearning.fragments.list

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.viewbinding.library.fragment.viewBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.annguyenhoang.to_doapplicationlearning.R
import com.annguyenhoang.to_doapplicationlearning.data.viewmodel.ToDoViewModel
import com.annguyenhoang.to_doapplicationlearning.databinding.FragmentListBinding

class ListFragment : Fragment(R.layout.fragment_list) {

    private val binding: FragmentListBinding by viewBinding()

    private val adapter: ListAdapter by lazy { ListAdapter() }
    private val mToDoViewModel: ToDoViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setHasOptionsMenu(true)

        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

        mToDoViewModel.getAllData.observe(viewLifecycleOwner, { data ->
            adapter.setData(data)
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.list_fragment_menu, menu)
    }

}