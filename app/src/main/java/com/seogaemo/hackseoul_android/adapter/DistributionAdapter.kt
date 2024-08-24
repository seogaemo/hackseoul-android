package com.seogaemo.hackseoul_android.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.seogaemo.hackseoul_android.data.Distribution
import com.seogaemo.hackseoul_android.databinding.DistributionItemBinding
import com.seogaemo.hackseoul_android.view.DistributionActivity

class DistributionAdapter (private val distributionList: List<Distribution>):
    RecyclerView.Adapter<DistributionAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DistributionItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding).also { hanler ->
            binding.root.setOnClickListener {
                val context = binding.root.context
                context.startActivity(Intent(context, DistributionActivity::class.java))
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(distributionList[position])
    }

    override fun getItemCount(): Int = distributionList.size

    inner class ViewHolder(private val binding : DistributionItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item : Distribution){
            binding.companyText.text = item.company
            binding.dateText.text = item.date
            if (item.isCoupang) binding.coupangImageView.visibility = View.VISIBLE
            else binding.coupangImageView.visibility = View.GONE
        }
    }
}