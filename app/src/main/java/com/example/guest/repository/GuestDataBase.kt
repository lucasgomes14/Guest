package com.example.guest.repository

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.guest.constants.DataBaseConstants

class GuestDataBase(context: Context) : SQLiteOpenHelper(context, NAME, null, VERSION) {
    companion object {
        private const val NAME = "guestbd"
        private const val VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE " + DataBaseConstants.GUEST.TABLE_NAME +
                "(" + DataBaseConstants.GUEST.COLUMN.ID + " INTEGER primary key autoincrement," +
                DataBaseConstants.GUEST.COLUMN.NAME + " TEXT," +
                DataBaseConstants.GUEST.COLUMN.PRESENCE + " INTEGER);")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {}
}