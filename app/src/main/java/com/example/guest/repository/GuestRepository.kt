package com.example.guest.repository

class GuestRepository private constructor(){

    // singleton
    companion object {
        private lateinit var repository: GuestRepository

        fun getInstance(): GuestRepository {
            if (!::repository.isInitialized) {
                repository = GuestRepository()
            }

            return repository
        }
    }
}