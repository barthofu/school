package fr.bartho.tp4.data

import android.net.Uri
import android.text.Editable

data class Contact(
    val firstName: String,
    val lastName: String,
    val tel: String,
    val mail: String,
    val image: Uri
) {

}

class ContactsData {

    companion object {

        val contacts: ArrayList<Contact> = arrayListOf()
    }
}