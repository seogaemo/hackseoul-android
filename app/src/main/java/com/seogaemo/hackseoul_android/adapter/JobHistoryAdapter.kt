package com.seogaemo.hackseoul_android.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.seogaemo.hackseoul_android.data.JobHistory
import com.seogaemo.hackseoul_android.databinding.JobHistoryItemBinding

class JobHistoryAdapter (private val jobHistoryList: List<JobHistory>):
    RecyclerView.Adapter<JobHistoryAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = JobHistoryItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(jobHistoryList[position])
    }

    override fun getItemCount(): Int = jobHistoryList.size

    inner class ViewHolder(private val binding : JobHistoryItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item : JobHistory){
            binding.titleText.text = item.title
            binding.contentText.text = item.content
        }
    }
}