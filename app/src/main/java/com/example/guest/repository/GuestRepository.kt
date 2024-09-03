package com.example.guest.repository

import android.content.ContentValues
import android.content.Context
import com.example.guest.constants.DataBaseConstants
import com.example.guest.model.GuestModel

class GuestRepository private constructor(context: Context){

    private val guestDataBase = GuestDataBase(context)

    // singleton
    companion object {
        private lateinit var repository: GuestRepository

        fun getInstance(context: Context): GuestRepository {
            if (!::repository.isInitialized) {
                repository = GuestRepository(context)
            }

            return repository
        }
    }

    fun insert(model: GuestModel): Boolean {
        return try {
            val db = guestDataBase.writableDatabase
            val presence = if (model.presence) 1 else 0
            val values = ContentValues()

            values.put(DataBaseConstants.GUEST.COLUMN.NAME, model.name)
            values.put(DataBaseConstants.GUEST.COLUMN.PRESENCE, presence)

            db.insert(DataBaseConstants.GUEST.TABLE_NAME, null, values)
            true
        } catch (e: Exception) {
            false
        }
    }
}