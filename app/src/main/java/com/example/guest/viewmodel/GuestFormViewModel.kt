package com.example.guest.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.guest.model.GuestModel
import com.example.guest.repository.GuestRepository

class GuestFormViewModel(application: Application): AndroidViewModel(application) {
    private val repository = GuestRepository.getInstance(application)

    fun insert(model: GuestModel) {
        repository.insert(model)
    }
}