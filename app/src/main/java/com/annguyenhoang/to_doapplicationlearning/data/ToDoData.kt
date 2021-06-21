package com.annguyenhoang.to_doapplicationlearning.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo_table")
data class ToDoData(
    @PrimaryKey(autoGenerate = true)
    var title: String,
    var priority: Priority,
    var description: String
)