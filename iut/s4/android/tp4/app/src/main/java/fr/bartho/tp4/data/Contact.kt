package fr.bartho.tp4.data

import android.annotation.SuppressLint
import android.content.Context
import java.io.*

data class Contact (
    val firstName: String,
    val lastName: String,
    val phone: String?,
    val email: String?,
    val birthdate: String?,
    val sex: Int,
    val image: String?
) : Serializable {
}

