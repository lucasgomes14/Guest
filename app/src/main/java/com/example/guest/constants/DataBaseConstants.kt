package com.example.guest.constants

class DataBaseConstants private constructor() {
    object GUEST {
        const val TABLE_NAME = "Guest"
        const val ID = "guestid"

        object COLUMN {
            const val ID = "id"
            const val NAME = "name"
            const val PRESENCE = "presence"
        }
    }
}