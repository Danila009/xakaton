package com.example.normalhackathon.api

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.normalhackathon.api.repository.Repository

class ViewModelFactory(private val repository: Repository):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}