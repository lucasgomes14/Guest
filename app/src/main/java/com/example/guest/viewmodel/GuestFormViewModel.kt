package com.example.guest.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.guest.model.GuestModel
import com.example.guest.repository.GuestRepository

class GuestFormViewModel(application: Application): AndroidViewModel(application) {
    private val repository = GuestRepository.getInstance(application)

    private val _guestModel = MutableLiveData<GuestModel>()
    val guestModel: LiveData<GuestModel> = _guestModel

    private val _saveGuest = MutableLiveData<String>()
    val saveGuest: LiveData<String> = _saveGuest

    fun save(model: GuestModel) {
        if (model.id == 0) {
            if (repository.insert(model)) {
                _saveGuest.value = "Inserted successfully"
            } else {
                _saveGuest.value = "Failed"
            }
        } else {
            if (repository.update(model)) {
                _saveGuest.value = "Updated successfully"
            } else {
                _saveGuest.value = "Failed"
            }
        }
    }

    fun get(id: Int) {
        _guestModel.value = repository.get(id)
    }
}