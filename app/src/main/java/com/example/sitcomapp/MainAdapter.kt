package com.example.sitcomapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.sitcomapp.databinding.RecyclerViewLayoutBinding


class MainAdapter(val sitcomList :List<Sitcoms>):RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
private var onClick: OnClickListner?= null

    inner class MainViewHolder(val itemBinding:RecyclerViewLayoutBinding)
        :RecyclerView.ViewHolder(itemBinding.root){
        fun  bindItem(task: Sitcoms){
            itemBinding.ivImage.setImageResource(task.img)
            itemBinding.tvTitle.text=task.title
            itemBinding.descriptionSitcom.text= task.description
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(RecyclerViewLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val task = sitcomList[position]
        holder.bindItem(task)
        holder.itemView.setOnClickListener {
            onClick!!.onClick(position)
        }
    }

    override fun getItemCount(): Int {
        return sitcomList.size
    }

    interface OnClickListner{
        fun onClick(position: Int)
    }

    fun setOnClickListner(onClickListener: OnClickListner){
        this.onClick=onClickListener
    }



}