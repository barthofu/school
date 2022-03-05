package fr.bartho.tp4.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ListView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import fr.bartho.tp4.adapter.ContactAdapter
import fr.bartho.tp4.data.Contact
import fr.bartho.tp4.data.ContactsData
import fr.bartho.tp4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //private var contacts: ArrayList<Contact> = arrayListOf()

    private lateinit var listView: ListView
    private lateinit var addButton: FloatingActionButton
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()

        listView = binding.contacts
        addButton = binding.addButton

        val contacts = ContactsData.contacts

        val contactAdapter = ContactAdapter(this, contacts)
        listView.adapter = contactAdapter

        listView.setOnItemClickListener { parent, view: View, position: Int, id: Long ->
            Snackbar.make(listView, contacts[position].firstName + " " + contacts[position].lastName, Snackbar.LENGTH_SHORT).show()
        }

        listView.setOnItemLongClickListener { parent, view: View, position: Int, id: Long ->

            contacts.removeAt(position)
            contactAdapter.notifyDataSetChanged()
            return@setOnItemLongClickListener true
        }

        addButton.setOnClickListener {
            val intent = Intent(this, AddContactActivity::class.java)
            startActivity(intent)
        }
    }
}