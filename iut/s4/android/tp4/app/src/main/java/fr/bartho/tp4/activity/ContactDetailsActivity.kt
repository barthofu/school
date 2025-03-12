package fr.bartho.tp4.activity

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.bartho.tp4.R
import fr.bartho.tp4.data.Contact
import fr.bartho.tp4.databinding.ActivityContactDetailsBinding
import fr.bartho.tp4.utils.ManageContacts
import java.io.FileInputStream

class ContactDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityContactDetailsBinding

    private var contact: Contact? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityContactDetailsBinding.inflate(layoutInflater)

        val extras: Bundle? = intent.extras
        if (extras != null) {
            val position: Int = extras.getInt("position")
            contact = ManageContacts.getByPosition(position)

            this.setImage()
            this.setName()
            this.setInfos()
        }

        setContentView(binding.root)
    }

    private fun setImage () {

        val imageName: String? = contact!!.image
        var bitmap: Bitmap? = null

        try {
            val file: FileInputStream = openFileInput(imageName)
            bitmap = BitmapFactory.decodeStream(file)
            file.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        if (bitmap != null) binding.image.setImageBitmap(bitmap)
    }

    private fun setName () {

        val name: String = contact!!.firstName + " " + contact!!.lastName
        binding.name.text = name
    }

    private fun setInfos () {

        val birthdate: String? = contact!!.birthdate
        val sex: String = if (contact!!.sex == 0) getString(R.string.male) else getString(R.string.female)
        val mail: String? = contact!!.email
        val phone: String? = contact!!.phone

        binding.infos.text = "${birthdate}\n${sex}\n${mail}\n${phone}"
    }
}