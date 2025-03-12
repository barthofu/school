package fr.bartho.tp3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.bartho.tp3.databinding.ActivityCBinding

class ActivityC : AppCompatActivity() {

    private lateinit var binding: ActivityCBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val message = intent.getStringExtra("text")
        binding.textView.apply {
            text = message
        }
    }
}