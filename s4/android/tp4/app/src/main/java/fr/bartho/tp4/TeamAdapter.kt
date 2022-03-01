package fr.bartho.tp4

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import java.util.*
import kotlin.collections.ArrayList

class TeamAdapter : BaseAdapter {

    private var context: Context
    private var list: ArrayList<String>

    constructor(context : Context, list : ArrayList<String>) {
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

        if (convertView == null) {
            layoutItem =  mInflater.inflate(R.layout.item_layout, parent, false) as ConstraintLayout
        } else {
            layoutItem = convertView as ConstraintLayout
        }

        var textView: TextView = layoutItem.findViewById(R.id.textView)
        var imageView: ImageView = layoutItem.findViewById(R.id.imageView)

        textView.text = list[position]

        var resId: Int = context.resources.getIdentifier("ic_" + list[position].lowercase(Locale.getDefault()), "mipmap", context.packageName)

        if (resId == 0) imageView.setImageResource(R.mipmap.ic_launcher)
        else imageView.setImageResource(resId)

        return layoutItem
    }
}