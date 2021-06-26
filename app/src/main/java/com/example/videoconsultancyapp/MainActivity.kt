package com.example.videoconsultancyapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions
import java.net.MalformedURLException
import java.net.URL

class MainActivity : AppCompatActivity() {
    lateinit var Adapter:Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try {
            val options = JitsiMeetConferenceOptions.Builder()
                .setServerURL(URL("https://meet.jit.si"))
                .setWelcomePageEnabled(false)
                .build()
        } catch (e: MalformedURLException) {
            e.printStackTrace()
        }
        val RecyclerView: RecyclerView =findViewById(R.id.RecyclerView)

        Adapter= Adapter(this)
        RecyclerView.layoutManager= StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        RecyclerView.adapter=Adapter
        Btn.setOnClickListener {
            val dialIntent = Intent(Intent.ACTION_DIAL)
            dialIntent.data = Uri.parse("tel:" + "102")
            startActivity(dialIntent)
        }
    }
}