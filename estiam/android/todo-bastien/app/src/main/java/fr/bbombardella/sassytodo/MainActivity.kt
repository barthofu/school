package fr.bgili.todo

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import fr.bgili.todo.database.TodoDatabase
import fr.bgili.todo.entities.Todo

class MainActivity : AppCompatActivity() {

    private val database: TodoDatabase
        get() = TodoDatabase.getDatabase(applicationContext)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.database.todoDao().add(Todo(null, "Test", "URGENT"))

        findViewById<TextView>(R.id.tvHelloWord)?.text =
            this.database.todoDao().findAll().joinToString { "%d - %s".format(it.id, it.name) }
    }
}