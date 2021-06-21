package com.annguyenhoang.to_doapplicationlearning.data.repository

import androidx.lifecycle.LiveData
import com.annguyenhoang.to_doapplicationlearning.data.ToDoDao
import com.annguyenhoang.to_doapplicationlearning.data.models.ToDoData

class ToDoRepository(
    private val toDoDao: ToDoDao
) {

    val getAllData: LiveData<List<ToDoData>> = toDoDao.getAllData()

    suspend fun insertDAta(toDoData: ToDoData) {
        toDoDao.insertData(toDoData = toDoData)
    }

}