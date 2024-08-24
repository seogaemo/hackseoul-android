package com.seogaemo.hackseoul_android.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.seogaemo.hackseoul_android.data.Table
import com.seogaemo.hackseoul_android.databinding.TableItemBinding

class TableAdapter (private val tableList: List<Table>):
    RecyclerView.Adapter<TableAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = TableItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(tableList[position])
    }

    override fun getItemCount(): Int = tableList.size

    inner class ViewHolder(private val binding : TableItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item : Table){
            binding.typeText.text = item.type
            binding.titleText.text = item.title
        }
    }
}