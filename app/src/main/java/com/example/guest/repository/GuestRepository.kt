package com.example.guest.repository

import android.content.ContentValues
import android.content.Context
import com.example.guest.constants.DataBaseConstants
import com.example.guest.model.GuestModel

class GuestRepository (context: Context) {

    private val guestDataBase = GuestDataBase.getDatabase(context).guestDAO()

    fun insert(model: GuestModel): Boolean {
        return guestDataBase.insert(model) > 0
    }

    fun update(model: GuestModel): Boolean {
        return guestDataBase.update(model) > 0
    }

    fun delete(id: Int) {
        val guest = get(id)
        guestDataBase.delete(guest)
    }

    fun getAll(): List<GuestModel> {
        return guestDataBase.getAll()
    }

    fun get(id: Int): GuestModel {
        return guestDataBase.get(id)
    }

    fun getPresent(): List<GuestModel> {
        return guestDataBase.getPresent()
    }

    fun getAbsent(): List<GuestModel> {
        return guestDataBase.getAbsent()
    }
}