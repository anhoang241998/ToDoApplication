package com.annguyenhoang.to_doapplicationlearning.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.annguyenhoang.to_doapplicationlearning.data.models.ToDoData

@Dao
interface ToDoDao {

    // lay tat ca tu table todo_table voi id theo thu tu tang dan
    @Query("SELECT * FROM todo_table ORDER BY id ASC")
    fun getAllData(): LiveData<List<ToDoData>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertData(toDoData: ToDoData)

}