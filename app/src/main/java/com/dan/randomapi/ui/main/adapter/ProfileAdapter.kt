package com.dan.randomapi.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dan.randomapi.data.model.ResultProfile
import com.dan.randomapi.databinding.ItemBinding

class ProfileAdapter(private val dogsList: List<ResultProfile>,private val onClickListener: (ResultProfile) -> Unit) : RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder>() {

    class ProfileViewHolder(private val itemBinding: ItemBinding) : RecyclerView.ViewHolder(itemBinding.root){
        fun bind(profile: ResultProfile,onClickListener: (ResultProfile) -> Unit) {
            Glide.with(itemView.context)
                .load(profile.picture.large)
                .centerCrop()
                .into(itemBinding.ivPhoto)
            itemBinding.tvName.text = profile.name.first + " " +  profile.name.last
            itemBinding.tvDesc.text = profile.phone
            itemBinding.tvAge.text = profile.dob.age.toString() + " years"

            itemBinding.clContainer.setOnClickListener {
                onClickListener(profile)
            }

            itemBinding.materialCardView.setOnClickListener {
                onClickListener(profile)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBinding.inflate(inflater, parent, false)
        return ProfileViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        holder.bind(dogsList[position],onClickListener)
    }

    override fun getItemCount() = dogsList.size
}