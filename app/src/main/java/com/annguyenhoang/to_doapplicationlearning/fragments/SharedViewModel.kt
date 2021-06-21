package com.annguyenhoang.to_doapplicationlearning.fragments

import android.app.Application
import android.text.TextUtils
import androidx.lifecycle.AndroidViewModel
import com.annguyenhoang.to_doapplicationlearning.R
import com.annguyenhoang.to_doapplicationlearning.application.ToDoApplication
import com.annguyenhoang.to_doapplicationlearning.data.models.Priority

class SharedViewModel(application: Application) : AndroidViewModel(application) {

    fun verifyDataFromUser(
        title: String,
        description: String
    ): Boolean {
        return if (TextUtils.isEmpty(title) || TextUtils.isEmpty(description)) {
            false
        } else !(title.isEmpty() || description.isEmpty())
    }

    fun parsePriority(priority: String): Priority {
        return when (priority) {
            getApplication<ToDoApplication>().resources.getStringArray(R.array.priorities)[0] -> {
                Priority.HIGH
            }
            getApplication<ToDoApplication>().resources.getStringArray(R.array.priorities)[1] -> {
                Priority.MEDIUM
            }
            getApplication<ToDoApplication>().resources.getStringArray(R.array.priorities)[2] -> {
                Priority.LOW
            }
            else -> Priority.LOW
        }
    }

}