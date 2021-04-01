package com.example.android.openedu2_androidversion

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.openedu2_androidversion.data.Android
import java.text.FieldPosition

class AndroidAdapter(Context: Context,
                     private val android: List<Android>,
                     private val clickListener: (position: Int) -> Unit)
    :RecyclerView.Adapter<AndroidAdapter.ViewHolder>() {

        val inflater: LayoutInflater = LayoutInflater.from(Context)

    class ViewHolder(itemView: View, listener: (position: Int) -> Unit)
        :RecyclerView.ViewHolder(itemView){
        private val image: ImageView = itemView.findViewById(R.id.image)
        private val title: TextView = itemView.findViewById(R.id.title)

        init {
            itemView.setOnClickListener{
                val position = adapterPosition
                if (position!=RecyclerView.NO_POSITION){
                    listener(position)
                }
            }

        }

        fun bind(version: Android){
            image.setImageResource(version.imageAndroid)
            title.text = version.title
        }
    }

    override fun getItemCount(): Int = android.size
    fun getItem(position: Int): Android = android[position]

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(inflater.inflate(R.layout.item_android, parent, false), clickListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}