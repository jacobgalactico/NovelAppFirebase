package com.example.novelappfirebase

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.novelapp.Libro

class SharedViewModel : ViewModel() {
    private val _selectedLibro = MutableLiveData<Libro?>()
    val selectedLibro: LiveData<Libro?> = _selectedLibro

    fun selectLibro(libro: Libro) {
        _selectedLibro.value = libro
    }
}
