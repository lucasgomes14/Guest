package com.example.guest.view.viewholder

import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.guest.databinding.RowGuestBinding
import com.example.guest.model.GuestModel
import com.example.guest.view.listener.OnGuestListener

class GuestViewHolder(private val item: RowGuestBinding, private val listener: OnGuestListener) :
    RecyclerView.ViewHolder(item.root) {
    fun bind(guest: GuestModel) {
        item.textName.text = guest.name

        item.textName.setOnClickListener {
            listener.onClick(guest.id)
        }

        item.textName.setOnLongClickListener {
            AlertDialog.Builder(itemView.context)
                .setTitle("Remoção de convidado")
                .setMessage("Tem certeza que deseja remover?")
                .setPositiveButton("Sim") { dialog, which ->
                    listener.onDelete(guest.id)
                }.setNegativeButton("Não", null)
                .create()
                .show()
            true
        }
    }
}