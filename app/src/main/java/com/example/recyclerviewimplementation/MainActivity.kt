package com.example.recyclerviewimplementation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity(),MyAdapter.onDeleteClickListener {
    //now we will create our own custom list of objects of type MyData class
    private var mylist= mutableListOf(MyData(R.drawable.sasuke,"Train"))
    private var mylist2= mutableListOf(MyData(R.drawable.sasuke,"Train"))

    private lateinit var myAdapter: MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mylist.add(MyData(R.drawable.kakashi,"Bike"))
        mylist.add(MyData(R.drawable.tanjiro,"Train"))
        mylist.add(MyData(R.drawable.nezuko,"Bike"))
        mylist.add(MyData(R.drawable.naruto,"Person"))
        mylist.add(MyData(R.drawable.nbrasengan,"Car"))
        mylist.add(MyData(R.drawable.zenitsu,"Person"))
        mylist.add(MyData(R.drawable.inosuke,"Car"))
        mylist.add(MyData(R.drawable.giyu,"Train"))
        mylist.add(MyData(R.drawable.rengoku,"Train"))
        mylist.add(MyData(R.drawable.muzan,"Bike"))
        mylist2.addAll(mylist.subList(1,mylist.size))
//        mylist.shuffle()//kotlins way of shuffling
        //now we need an adapter to attach our data to our recyclerview
        //to do that first we need to create our recyclerview items layout now lets go
        //our example item is ready lets go create our adapter class
        //lets attach our adapter to the recycler view.
        mylist.shuffle()
        myAdapter= MyAdapter(this,mylist,this)
        val layoutmanager=StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        myrecyclerview.adapter=myAdapter
        myrecyclerview.layoutManager=layoutmanager
        myrecyclerview.startAnimation(AnimationUtils.loadAnimation(this,R.anim.item_animation_fall_down))
    }

    override fun onDeleteclick(myData: MyData, position: Int) {
        mylist.remove(myData)
        //myAdapter.notifyDataSetChanged()
        myAdapter.notifyItemRemoved(position)
        Log.i("item deleted","position: $position data: $myData")
    }
}