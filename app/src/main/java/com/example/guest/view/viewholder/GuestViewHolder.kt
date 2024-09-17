package com.example.guest.view.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.guest.databinding.RowGuestBinding
import com.example.guest.model.GuestModel
import com.example.guest.view.listener.OnGuestListener

class GuestViewHolder(private val item: RowGuestBinding, private val listener: OnGuestListener) : RecyclerView.ViewHolder(item.root) {
    fun bind(guest: GuestModel) {
        item.textName.text = guest.name

        item.textName.setOnClickListener {
            listener.onClick(guest.id)
        }
    }
}