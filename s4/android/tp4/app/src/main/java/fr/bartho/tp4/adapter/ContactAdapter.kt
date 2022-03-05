package fr.bartho.tp4.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import fr.bartho.tp4.R
import fr.bartho.tp4.data.Contact
import java.util.*
import kotlin.collections.ArrayList

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
        imageView.setImageURI(contact.image)

        //var resId: Int = context.resources.getIdentifier("ic_" + list[position].lowercase(Locale.getDefault()), "mipmap", context.packageName)
        //var resId: Int = 0

        //if (resId == 0) imageView.setImageResource(R.mipmap.ic_launcher)
        //else imageView.setImageResource(resId)

        return layoutItem
    }
}