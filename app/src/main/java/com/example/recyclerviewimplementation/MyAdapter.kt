package com.example.recyclerviewimplementation

import android.content.Context
import android.icu.text.Transliterator
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(val context: Context, val list:ArrayList<MyData>,val ondeleteClickListener: onDeleteClickListener)
    :RecyclerView.Adapter<MyAdapter.MyViewHolder>(){
    inner class MyViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val icon:ImageView=itemView.findViewById(R.id.itemicon)
        val name:TextView=itemView.findViewById(R.id.itemname)
        val delete:ImageView=itemView.findViewById(R.id.itemdelete)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val view=LayoutInflater.from(context).inflate(R.layout.exampleitem,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount()=list.size

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        val obj=list[position]
        holder.name.text=obj.name
        holder.icon.setImageResource(obj.icon)
        holder.itemView.setOnClickListener {
            holder.name.text="Index in bounds"
            //we are trying to change the text when we click on the whole item.
        }
        //now lets try to delete the item when the user tries to click on the delete icon
        holder.delete.setOnClickListener{
            if(position!=RecyclerView.NO_POSITION) {
                ondeleteClickListener.onDeleteclick(obj,position)
            }
        }
    }
    interface onDeleteClickListener{
        fun onDeleteclick(myData: MyData,position:Int)
    }
}