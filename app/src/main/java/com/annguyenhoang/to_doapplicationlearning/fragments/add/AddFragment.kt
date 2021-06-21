package com.annguyenhoang.to_doapplicationlearning.fragments.add

import android.os.Bundle
import android.text.TextUtils
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.viewbinding.library.fragment.viewBinding
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.annguyenhoang.to_doapplicationlearning.R
import com.annguyenhoang.to_doapplicationlearning.data.models.Priority
import com.annguyenhoang.to_doapplicationlearning.data.models.ToDoData
import com.annguyenhoang.to_doapplicationlearning.data.viewmodel.ToDoViewModel
import com.annguyenhoang.to_doapplicationlearning.databinding.FragmentAddBinding

class AddFragment : Fragment(R.layout.fragment_add) {

    private val binding: FragmentAddBinding by viewBinding()

    private val mToDoViewModel: ToDoViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.add_fragment_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.menu_add) {
            insertDataToDb()
        }

        return super.onOptionsItemSelected(item)
    }

    private fun insertDataToDb() {
        val title = binding.titleEt.text.toString()
        val priority = binding.prioritiesSpinner.selectedItem.toString()
        val description = binding.descriptionEt.text.toString()

        val validation = verifyDataFromUser(title, description)
        if (validation) {
            // insert data to database
            val newData = ToDoData(
                0,
                title,
                parsePriority(priority),
                description
            )
            mToDoViewModel.insertData(newData)
            Toast.makeText(requireContext(), "Successfully added!", Toast.LENGTH_SHORT).show()
            // navigate back
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        } else {
            Toast.makeText(requireContext(), "Please fill out all fields", Toast.LENGTH_SHORT)
                .show()
        }

    }

    private fun verifyDataFromUser(
        title: String,
        description: String
    ): Boolean {
        return if (TextUtils.isEmpty(title) || TextUtils.isEmpty(description)) {
            false
        } else !(title.isEmpty() || description.isEmpty())
    }

    private fun parsePriority(priority: String): Priority {
        return when (priority) {
            resources.getStringArray(R.array.priorities)[0] -> {
                Priority.HIGH
            }
            resources.getStringArray(R.array.priorities)[1] -> {
                Priority.MEDIUM
            }
            resources.getStringArray(R.array.priorities)[2] -> {
                Priority.LOW
            }
            else -> Priority.LOW
        }
    }
}