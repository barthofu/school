package fr.bartho.tp3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ActivityB : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)
/*        val message = intent.getStringExtra("text")
        findViewById<TextView>(R.id.textView).apply {
            text = message
        }*/
    }
}