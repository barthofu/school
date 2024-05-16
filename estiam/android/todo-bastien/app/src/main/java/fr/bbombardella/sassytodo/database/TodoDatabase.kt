package fr.bgili.todo.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import fr.bgili.todo.daos.TodoDao
import fr.bgili.todo.entities.Todo

@Database(entities = [Todo::class], version = 1)
abstract class TodoDatabase : RoomDatabase() {

    companion object {
        private var INSTANCE: TodoDatabase? = null

        fun getDatabase(applicationContext: Context): TodoDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    applicationContext,
                    TodoDatabase::class.java, "todo"
                ).allowMainThreadQueries().build()

                INSTANCE = instance

                instance
            }
        }
    }

    abstract fun todoDao(): TodoDao
}