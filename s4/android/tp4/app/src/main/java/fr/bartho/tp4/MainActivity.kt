package fr.bartho.tp4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.bartho.tp4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var listOfTeams: Array<String> = arrayOf("OL", "OM", "PSG", "LOSC", "GIRONDINS", "ASM", "OGC Nice", "ASSE")
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
    }
}