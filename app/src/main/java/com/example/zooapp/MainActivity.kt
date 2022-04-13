package com.example.zooapp

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var listOfAnimals = ArrayList<Animal>()
    private var adapter : AnimalsAdapter ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvListAnimal = findViewById<ListView>(R.id.tvListAnimal)

        listOfAnimals.add(
            Animal("Baboon","Baboon live in  big place with tree",R.drawable.baboon,false))
        listOfAnimals.add(
            Animal("Bulldog","Bulldog live in  big place with tree",R.drawable.bulldog,false))
        listOfAnimals.add(
            Animal("Panda","Panda live in  big place with tree",R.drawable.panda,true))
        listOfAnimals.add(
            Animal("Swallow","Swallow live in  big place with tree",R.drawable.swallow_bird,false))
        listOfAnimals.add(
            Animal("Tiger","Tiger live in  big place with tree",R.drawable.white_tiger,true))
        listOfAnimals.add(
            Animal("Zebra","Zebra live in  big place with tree",R.drawable.zebra,false))

        adapter = AnimalsAdapter(this,listOfAnimals)
        tvListAnimal.adapter =  adapter
    }

    fun delete(index:Int){
        listOfAnimals.removeAt(index)
        adapter!!.notifyDataSetChanged()
    }

    fun  add(index:Int){
        listOfAnimals.add(index,listOfAnimals[index])
        adapter!!.notifyDataSetChanged()
    }

    inner class AnimalsAdapter(context: Context, var listOfAnimals: ArrayList<Animal>) :
        BaseAdapter() {
        var context: Context?= context

        override fun getCount(): Int {
            return listOfAnimals.size
        }

        override fun getItem(p0: Int): Any {
            return listOfAnimals[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        @SuppressLint("ViewHolder", "InflateParams")
        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val animal = listOfAnimals[p0]

            if (animal.isKiller) {
                val inflater =
                    context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

                val myView = inflater.inflate(R.layout.animal_killer_ticket, null)
                val tvName = myView.findViewById<TextView>(R.id.tvName)
                val ivAnimalImage = myView.findViewById<ImageView>(R.id.ivAnimalImage)
                val tvDes = myView.findViewById<TextView>(R.id.tvDes)

                tvName.text = animal.name
                tvDes.text = animal.des
                ivAnimalImage.setImageResource(animal.image)
                ivAnimalImage.setOnClickListener {
                    val intent = Intent(context, AnimalInfo::class.java)
                    intent.putExtra("name", animal.name)
                    intent.putExtra("des", animal.des)
                    intent.putExtra("image", animal.image)
                    context!!.startActivity(intent)
                }
                return myView
            } else {
                val inflater =
                    context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

                val myView = inflater.inflate(R.layout.animal_ticket, null)
                val tvName = myView.findViewById<TextView>(R.id.tvName)
                val ivAnimalImage = myView.findViewById<ImageView>(R.id.ivAnimalImage)
                val tvDes = myView.findViewById<TextView>(R.id.tvDes)
                tvName.text = animal.name
                tvDes.text = animal.des
                ivAnimalImage.setImageResource(animal.image)
                ivAnimalImage.setOnClickListener {
//                    add(p0)
                    val intent = Intent(context, AnimalInfo::class.java)
                    intent.putExtra("name", animal.name)
                    intent.putExtra("des", animal.des)
                    intent.putExtra("image", animal.image)
                    context!!.startActivity(intent)
                }
                return myView
            }
        }
    }
}