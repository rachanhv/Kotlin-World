package com.kotlinworld.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView;
import org.w3c.dom.Text

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private var title = arrayOf("Chapter one", "Chapter two", "Chapter three","Chapter four",
        "Chapter five","Chapter six","Chapter seven","Chapter eight")
    private var details = arrayOf("Chapter one details", "Chapter two details", "Chapter three details","Chapter four details",
    "Chapter five details","Chapter six details","Chapter seven details","Chapter eight details")
private var images = arrayOf(R.drawable.download,R.drawable.download,R.drawable.download,R.drawable.download,
    R.drawable.download,R.drawable.download,R.drawable.download,R.drawable.download)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return title.size
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.itemTitle.text = title[position]
        holder.itemDetails.text = details[position]
        holder.itemImage.setImageResource(images[position])
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetails: TextView

        init {
            itemImage = itemView.findViewById(R.id.image_view)
            itemTitle = itemView.findViewById(R.id.title)
            itemDetails = itemView.findViewById(R.id.details)

            itemView.setOnClickListener {
                val position : Int = adapterPosition

                Toast.makeText(itemView.context, "you clicked on ${title[position]}", Toast.LENGTH_LONG).show()
            }
        }

    }
}