package fr.bartho.tp4.adapter

import android.content.Context
import android.content.Intent.getIntent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import fr.bartho.tp4.R
import fr.bartho.tp4.data.Contact
import java.io.FileInputStream
import java.util.*


class ContactAdapter : BaseAdapter {

    private var context: Context
    private var list: ArrayList<Contact>

    constructor(context : Context, list : ArrayList<Contact>) {
        this.context = context
        this.list = list
    }

    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(i: Int): Any {
        return list[i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        lateinit var layoutItem: ConstraintLayout
        var mInflater: LayoutInflater = LayoutInflater.from(context)
        val contact: Contact = list[position]

        layoutItem =
            if (convertView == null) mInflater.inflate(R.layout.item_layout, parent, false) as ConstraintLayout
            else convertView as ConstraintLayout

        var textView: TextView = layoutItem.findViewById(R.id.textView)
        var imageView: ImageView = layoutItem.findViewById(R.id.imageView)

        textView.text = contact.firstName + " " + contact.lastName

        val imageName: String? = contact.image
        var bitmap: Bitmap? = null

        try {
            val file: FileInputStream = context.openFileInput(imageName)
            bitmap = BitmapFactory.decodeStream(file)
            file.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        if (bitmap != null) imageView.setImageBitmap(bitmap)

        return layoutItem
    }
}