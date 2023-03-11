package com.example.finalproject.phone

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.finalproject.databinding.ItemRowPhoneBinding

class PhoneAdapter (
    private val listPhone: ArrayList<Phone>
) : RecyclerView.Adapter<PhoneAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val binding =
            ItemRowPhoneBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, photo, price) = listPhone[position]
        Glide.with(holder.itemView.context)
            .load(photo) // URL Gambar
            .apply(RequestOptions())
            .into(holder.binding.imgItemPhoto) // imageView mana yang akan diterapkan
        holder.binding.tvItemName.text = name
        holder.binding.tvItemPrice.text = price
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listPhone[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int = listPhone.size

    class ListViewHolder(var binding: ItemRowPhoneBinding) : RecyclerView.ViewHolder(binding.root)

    interface OnItemClickCallback {
        fun onItemClicked(data: Phone)
    }
}