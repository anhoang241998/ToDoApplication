package com.annguyenhoang.to_doapplicationlearning.data.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.annguyenhoang.to_doapplicationlearning.data.ToDoDatabase
import com.annguyenhoang.to_doapplicationlearning.data.models.ToDoData
import com.annguyenhoang.to_doapplicationlearning.data.repository.ToDoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ToDoViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val toDoDao = ToDoDatabase.getDatabase(application).toDoDao()
    private val repository: ToDoRepository

    private val getAllData: LiveData<List<ToDoData>>

    init {
        repository = ToDoRepository(toDoDao)
        getAllData = repository.getAllData
    }

    fun insertData(toDoData: ToDoData) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertDAta(toDoData)
        }
    }

}