package com.example.videoconsultancyapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import org.jitsi.meet.sdk.JitsiMeetActivity
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions


class Adapter(val context: Context): RecyclerView.Adapter<Adapter.viewHolder>() {
    val DiseaseList:Array<String> =arrayOf<String>("Neurologist","Gastroenterologist","Cardiologist","Gynaecologist","Pulmonologist","Dermatologist","ENT specialist","Corona Virus")
    var DoctorImage= arrayOf(R.drawable.neurology,R.drawable.digestion,R.drawable.cardiologist,R.drawable.pregnant,R.drawable.lungs,R.drawable.dermatologist,R.drawable.head,R.drawable.coronavirus)
    var id= arrayOf(100,101,102,103,104,105,106,107)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_view,parent,false)
        return viewHolder(view)
    }
    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.textview.text=DiseaseList[position]
        holder.imageView.setImageResource(DoctorImage[position])
        holder.cardView.setOnClickListener {
            if (id[position] > 0) {
                val options = JitsiMeetConferenceOptions.Builder().setRoom(id[position].toString()).build()
                JitsiMeetActivity.launch(context, options)
            }
        }
    }

    override fun getItemCount(): Int {
        return DiseaseList.size
    }
    inner class viewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        var textview:TextView=itemView.findViewById(R.id.doctorName)
        var imageView:ImageView=itemView.findViewById(R.id.doctorImage)
        var cardView: CardView=itemView.findViewById(R.id.cardView)
    }
}
