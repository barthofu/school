package fr.bgili.todo.services

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import fr.bgili.todo.dao.TaskDao
import fr.bgili.todo.entities.TaskEntity

@Database(
    entities = [
        TaskEntity::class
    ],
    version = 1)
abstract class DatabaseService : RoomDatabase() {

    private final

    // singleton pattern to ease the access to the database
    companion object {
        private var _instance: DatabaseService? = null

        fun getDatabase(applicationContext: android.content.Context): DatabaseService {
            return _instance ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    applicationContext,
                    DatabaseService::class.java, "todo"
                ).allowMainThreadQueries().build()

                _instance = instance

                instance
            }
        }
    }

    // dao accessors
    abstract fun taskDao(): TaskDao

}
