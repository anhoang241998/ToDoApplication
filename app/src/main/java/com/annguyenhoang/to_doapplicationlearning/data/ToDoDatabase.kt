package com.annguyenhoang.to_doapplicationlearning.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.annguyenhoang.to_doapplicationlearning.data.models.ToDoData

@Database(
    entities = [ToDoData::class],
    version = 1,
    exportSchema = true
)
@TypeConverters(Converter::class)
abstract class ToDoDatabase : RoomDatabase() {

    abstract fun toDoDao(): ToDoDao

    companion object {
        // Definition: Writes to this field are immediately
        // made visible to other threads
        @Volatile
        // Nếu có nhiều Thread sử dụng cái instance
        // này nó sẽ sử dụng version mới nhất
        private var INSTANCE: ToDoDatabase? = null

        fun getDatabase(context: Context): ToDoDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ToDoDatabase::class.java,
                    "todo_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}