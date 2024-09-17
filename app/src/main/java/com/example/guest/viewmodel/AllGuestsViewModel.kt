package com.example.guest.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.guest.model.GuestModel
import com.example.guest.repository.GuestRepository

class AllGuestsViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = GuestRepository.getInstance(application)

    private val _listGuest = MutableLiveData<List<GuestModel>>()
    val  listGuest: LiveData<List<GuestModel>> = _listGuest

    fun getAll() {
        _listGuest.value = repository.getAll()
    }

    fun delete(id: Int) {
        repository.delete(id)
    }
}