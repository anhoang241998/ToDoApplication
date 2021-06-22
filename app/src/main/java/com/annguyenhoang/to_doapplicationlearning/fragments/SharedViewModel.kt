package com.annguyenhoang.to_doapplicationlearning.fragments

import android.app.Application
import android.text.TextUtils
import android.view.View
import android.widget.AdapterView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.lifecycle.AndroidViewModel
import com.annguyenhoang.to_doapplicationlearning.R
import com.annguyenhoang.to_doapplicationlearning.application.ToDoApplication
import com.annguyenhoang.to_doapplicationlearning.data.models.Priority

class SharedViewModel(application: Application) : AndroidViewModel(application) {

    val listener: AdapterView.OnItemSelectedListener =
        object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                when (position) {
                    0 -> {
                        (parent?.getChildAt(0) as TextView).setTextColor(
                            ContextCompat.getColor(
                                application,
                                R.color.red
                            )
                        )
                    }
                    1 -> {
                        (parent?.getChildAt(0) as TextView).setTextColor(
                            ContextCompat.getColor(
                                application,
                                R.color.yellow
                            )
                        )
                    }
                    2 -> {
                        (parent?.getChildAt(0) as TextView).setTextColor(
                            ContextCompat.getColor(
                                application,
                                R.color.green
                            )
                        )
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}

        }

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