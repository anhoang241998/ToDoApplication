package com.annguyenhoang.to_doapplicationlearning.data.repository

import androidx.lifecycle.LiveData
import com.annguyenhoang.to_doapplicationlearning.data.ToDoDao
import com.annguyenhoang.to_doapplicationlearning.data.models.ToDoData

class ToDoRepository(
    private val toDoDao: ToDoDao
) {

    val getAllData: LiveData<List<ToDoData>> = toDoDao.getAllData()

    suspend fun insertData(toDoData: ToDoData) {
        toDoDao.insertData(toDoData = toDoData)
    }

    suspend fun updateData(toDoData: ToDoData) {
        toDoDao.updateData(toDoData)
    }

    suspend fun deleteItem(toDoData: ToDoData) {
        toDoDao.deleteItem(toDoData)
    }

    suspend fun deleteAll() {
        toDoDao.deleteAll()
    }

}