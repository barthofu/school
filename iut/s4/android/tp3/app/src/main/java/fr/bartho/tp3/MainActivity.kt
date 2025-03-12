package fr.bartho.tp3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.bartho.tp3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonB.setOnClickListener() {
            val intent = Intent(this, ActivityB::class.java).apply {
                putExtra("text", binding.input.text.toString())
            }
            startActivity(intent)
        }

        binding.buttonC.setOnClickListener() {
            val intent = Intent(this, ActivityC::class.java).apply {
                putExtra("text", binding.input.text.toString())
            }
            startActivity(intent)
        }
    }
}