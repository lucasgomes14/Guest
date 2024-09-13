package com.example.guest.view.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.guest.databinding.RowGuestBinding
import com.example.guest.model.GuestModel

class GuestViewHolder(private val item: RowGuestBinding) : RecyclerView.ViewHolder(item.root) {
    fun bind(guest: GuestModel) {
        item.textName.text = guest.name
    }
}