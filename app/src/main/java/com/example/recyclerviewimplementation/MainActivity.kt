package com.example.recyclerviewimplementation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity(),MyAdapter.onDeleteClickListener {
    //now we will create our own custom list of objects of type MyData class
    private lateinit var mylist:ArrayList<MyData>
    private lateinit var myAdapter: MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mylist= ArrayList()
        mylist.add(MyData(R.drawable.ic_baseline_person_24,"Person"))
        mylist.add(MyData(R.drawable.ic_baseline_directions_car_24,"Car"))
        mylist.add(MyData(R.drawable.ic_baseline_train_24,"Train"))
        mylist.add(MyData(R.drawable.ic_baseline_directions_bike_24,"Bike"))
        mylist.add(MyData(R.drawable.ic_baseline_access_time_24,"Time"))
        mylist.add(MyData(R.drawable.ic_baseline_person_24,"Person"))
        mylist.add(MyData(R.drawable.ic_baseline_directions_car_24,"Car"))
        mylist.add(MyData(R.drawable.ic_baseline_train_24,"Train"))
        mylist.add(MyData(R.drawable.ic_baseline_directions_bike_24,"Bike"))
        mylist.add(MyData(R.drawable.ic_baseline_access_time_24,"Time"))
        mylist.add(MyData(R.drawable.ic_baseline_person_24,"Person"))
        mylist.add(MyData(R.drawable.ic_baseline_directions_car_24,"Car"))
        mylist.add(MyData(R.drawable.ic_baseline_train_24,"Train"))
        mylist.add(MyData(R.drawable.ic_baseline_directions_bike_24,"Bike"))
        mylist.add(MyData(R.drawable.ic_baseline_access_time_24,"Time"))
//        mylist.shuffle()//kotlins way of shuffling
        //now we need an adapter to attach our data to our recyclerview
        //to do that first we need to create our recyclerview items layout now lets go
        //our example item is ready lets go create our adapter class
        //lets attach our adapter to the recycler view.
        myAdapter= MyAdapter(this,mylist,this)
        myrecyclerview.adapter=myAdapter
    }

    override fun onDeleteclick(myData: MyData, position: Int) {
        mylist.remove(myData)
        //myAdapter.notifyDataSetChanged()
        myAdapter.notifyItemRemoved(position)
        Log.i("item deleted","position: $position data: $myData")
    }
}