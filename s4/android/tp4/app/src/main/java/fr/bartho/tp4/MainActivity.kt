package fr.bartho.tp4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import com.google.android.material.snackbar.Snackbar
import fr.bartho.tp4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var listOfTeams: ArrayList<String> = arrayListOf("OL", "OM", "PSG", "LOSC", "GIRONDINS", "ASM", "OGC", "ASSE")

    private lateinit var listView: ListView
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        listView = binding.teams

        val teamAdapter: TeamAdapter = TeamAdapter(this, listOfTeams)
        listView.adapter = teamAdapter

        listView.setOnItemClickListener { parent, view: View, position: Int, id: Long ->
           Snackbar.make(listView, listOfTeams[position], Snackbar.LENGTH_SHORT).show()
        }

        listView.setOnItemLongClickListener { parent, view: View, position: Int, id: Long ->

            listOfTeams.removeAt(position)
            teamAdapter.notifyDataSetChanged()
            println(listOfTeams)
            return@setOnItemLongClickListener true
        }

        setContentView(binding.root)
    }
}