package com.example.guest.viewmodel

import androidx.lifecycle.ViewModel
import com.example.guest.repository.GuestRepository

class GuestFormViewModel: ViewModel() {
    private val repository = GuestRepository.getInstance()
}