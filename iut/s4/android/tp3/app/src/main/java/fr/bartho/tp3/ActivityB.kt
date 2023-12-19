package fr.bartho.tp3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.bartho.tp3.databinding.ActivityBBinding

class ActivityB : AppCompatActivity() {

    private lateinit var binding: ActivityBBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val message = intent.getStringExtra("text")
        binding.textView.apply {
            text = message
        }
    }
}