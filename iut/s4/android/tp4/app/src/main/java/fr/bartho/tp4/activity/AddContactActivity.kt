package fr.bartho.tp4.activity

import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.text.Editable
import android.widget.DatePicker
import androidx.appcompat.app.AppCompatActivity
import fr.bartho.tp4.data.Contact
import fr.bartho.tp4.databinding.ActivityAddContactBinding
import fr.bartho.tp4.utils.ManageContacts
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.*


@Suppress("DEPRECATION")
class AddContactActivity : AppCompatActivity() {

    //private var imageUri: Uri? = null
    private var imageName: String? = null
    private lateinit var binding: ActivityAddContactBinding

    private val PICK_IMAGE = 100
    private val FILE_NAME_LENGTH = 20
    private val CHAR_POOL : List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddContactBinding.inflate(layoutInflater)

        this.manageImage()
        this.manageBirthdate()
        this.manageValidateButton()

        setContentView(binding.root)
    }

    private fun manageValidateButton() {

        val validateButton = binding.validateBtn

        validateButton.setOnClickListener {

            // On ajoute le contact dans la liste
            addContactFromInputs()

            // On redirige vers l'activité principale
            finish()
        }
    }

    private fun manageImage() {

        val imageButton = binding.inputImage

        imageButton.setOnClickListener {
            this.openGallery()
        }
    }

    private fun manageBirthdate () {

        val birthdate = binding.inputBirthdate
        val myCalendar = Calendar.getInstance()

        val dateSetListener = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            myCalendar.set(Calendar.YEAR, year)
            myCalendar.set(Calendar.MONTH, monthOfYear)
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            val myFormat = "dd.MM.yyyy" // mention the format you need
            val sdf = SimpleDateFormat(myFormat, Locale.US)
            birthdate.setText(sdf.format(myCalendar.time))
        }

        birthdate.setOnClickListener {
            DatePickerDialog(this@AddContactActivity, dateSetListener,
                myCalendar.get(Calendar.YEAR),
                myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)).show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)


        if (resultCode === RESULT_OK && requestCode === PICK_IMAGE) {
            val selectedImage: Uri? = data?.data;

            if (selectedImage != null) {

                var bitmap: Bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, selectedImage)

                try {
                    //Write file
                    val filename = getRandomFileName()
                    val stream: FileOutputStream = openFileOutput(filename, Context.MODE_PRIVATE)
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)

                    binding.inputImage.setImageBitmap(bitmap)

                    //Cleanup
                    stream.close()

                    imageName = filename
                } catch (e: Exception) {
                    e.printStackTrace()
                }
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
            binding.inputBirthdate.text.toString(),
            if (binding.inputSexMale.isChecked) 0 else 1,
            imageName
        )

        ManageContacts.add(this, contact)
    }

    private fun getRandomFileName (): String {
        return (1..FILE_NAME_LENGTH)
            .map { _ -> kotlin.random.Random.nextInt(0, CHAR_POOL.size) }
            .map(CHAR_POOL::get)
            .joinToString("")
    }
}