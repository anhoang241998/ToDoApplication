package com.annguyenhoang.to_doapplicationlearning.fragments.update

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.viewbinding.library.fragment.viewBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.annguyenhoang.to_doapplicationlearning.R
import com.annguyenhoang.to_doapplicationlearning.data.models.Priority
import com.annguyenhoang.to_doapplicationlearning.databinding.FragmentUpdateBinding
import com.annguyenhoang.to_doapplicationlearning.fragments.SharedViewModel

class UpdateFragment : Fragment(R.layout.fragment_update) {

    private val binding: FragmentUpdateBinding by viewBinding()
    private val args by navArgs<UpdateFragmentArgs>()

    private val mSharedViewModel: SharedViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)

        binding.currentTitleEt.setText(args.currentItem.title)
        binding.currentDescriptionEt.setText(args.currentItem.description)

        binding.currentPrioritiesSpinner.setSelection(parsePriority(args.currentItem.priority))
        binding.currentPrioritiesSpinner.onItemSelectedListener = mSharedViewModel.listener
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.update_fragment_menu, menu)
    }

    private fun parsePriority(priority: Priority): Int {
        return when (priority) {
            Priority.HIGH -> {
                0
            }
            Priority.MEDIUM -> {
                1
            }
            Priority.LOW -> {
                2
            }
        }
    }

}