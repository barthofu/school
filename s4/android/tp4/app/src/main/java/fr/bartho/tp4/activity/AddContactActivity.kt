package fr.bartho.tp4.activity

import android.R.attr
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.appcompat.app.AppCompatActivity
import fr.bartho.tp4.data.Contact
import fr.bartho.tp4.data.ContactsData
import fr.bartho.tp4.databinding.ActivityAddContactBinding


@Suppress("DEPRECATION")
class AddContactActivity : AppCompatActivity() {

    private lateinit var imageUri: Uri
    private val PICK_IMAGE = 100
    private lateinit var binding: ActivityAddContactBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddContactBinding.inflate(layoutInflater)

        val validateButton = binding.validateBtn
        val imageButton = binding.inputImage

        imageButton.setOnClickListener {
            openGallery()
        }

        validateButton.setOnClickListener {

            // On ajoute le contact dans la liste
            addContactFromInputs()

            // On redirige vers l'activité principale
            finish()
        }

        setContentView(binding.root)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode === RESULT_OK && requestCode === PICK_IMAGE) {
            if (data != null) {
                imageUri = data.data!!

                binding.inputImage.setImageURI(imageUri)
            }
        }
    }

    private fun openGallery () {

        val gallery = Intent(
            Intent.ACTION_PICK,
            MediaStore.Images.Media.INTERNAL_CONTENT_URI
        )
        startActivityForResult(gallery, PICK_IMAGE)
    }

    private fun addContactFromInputs () {

        val contact = Contact(
            binding.inputFirstName.text.toString(),
            binding.inputLastName.text.toString(),
            binding.inputPhone.text.toString(),
            binding.inputEmail.text.toString(),
            imageUri
        )

        ContactsData.contacts.add(contact)

    }
}