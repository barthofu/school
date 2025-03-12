package fr.bartho.tp4.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import fr.bartho.tp4.adapter.ContactAdapter
import fr.bartho.tp4.databinding.ActivityMainBinding
import fr.bartho.tp4.utils.ManageContacts

class MainActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var addButton: FloatingActionButton
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        listView = binding.contacts

        addButton = binding.addButton
        addButton.setOnClickListener {
            val intent = Intent(this, AddContactActivity::class.java)
            startActivity(intent)
        }

        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()

        ManageContacts.loadFromDisk(this)
        val contacts = ManageContacts.contacts

        val contactAdapter = ContactAdapter(this, contacts)
        listView.adapter = contactAdapter

        listView.setOnItemClickListener { parent, view: View, position: Int, id: Long ->
            val intent = Intent(this@MainActivity, ContactDetailsActivity::class.java)
            intent.putExtra("position", position)
            startActivity(intent)
        }

        listView.setOnItemLongClickListener { parent, view: View, position: Int, id: Long ->

            // Suppression du contact dans le Manager
            ManageContacts.deleteByPosition(this, position)

            // Notification
            contactAdapter.notifyDataSetChanged()

            return@setOnItemLongClickListener true
        }
    }
}