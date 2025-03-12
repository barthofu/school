package fr.bartho.tp4.utils

import android.content.Context
import fr.bartho.tp4.data.Contact
import java.io.*

object ManageContacts: Serializable {

    val SAVE_FILENAME = "saveContacts"

    var contacts: ArrayList<Contact> = arrayListOf()

    fun saveToDisk (context: Context) {

        try {
            val fos: FileOutputStream = context.applicationContext.openFileOutput(SAVE_FILENAME, Context.MODE_PRIVATE)
            val out = ObjectOutputStream(fos)

            out.writeObject(contacts)

            out.close()
            fos.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    fun loadFromDisk (context: Context) {

        val directory: File = context.filesDir
        val file = File(directory, SAVE_FILENAME)

        if (file.exists()) {

            try {
                val fileInputStream: FileInputStream = context.applicationContext.openFileInput(SAVE_FILENAME)
                val inputStream = ObjectInputStream(fileInputStream)

                val contacts = inputStream.readObject() as ArrayList<Contact>
                this.contacts = contacts

                inputStream.close()
                fileInputStream.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

    }

    fun deleteByPosition(context: Context, position: Int) {
        contacts.removeAt(position)
        saveToDisk(context)
    }

    fun add(context: Context, contact: Contact) {
        contacts.add(contact)
        saveToDisk(context)
    }

    fun getByPosition(position: Int): Contact {
        return contacts[position]
    }
}