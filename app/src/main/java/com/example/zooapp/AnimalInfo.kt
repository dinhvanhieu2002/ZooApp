package com.example.zooapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class AnimalInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_info)

        val ivAnimalImage = findViewById<ImageView>(R.id.ivAnimalImage)
        val tvName = findViewById<TextView>(R.id.tvName)
        val tvDes = findViewById<TextView>(R.id.tvDes)

        val bundle:Bundle = intent.extras!!
        val name =bundle.getString("name")
        val des = bundle.getString("des")
        val image=bundle.getInt("image")
        ivAnimalImage.setImageResource(image)
        tvName.text=name
        tvDes.text=des
    }
}