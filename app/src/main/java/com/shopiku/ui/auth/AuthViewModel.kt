package com.shopiku.ui.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shopiku.data.repository.MockRepository
import com.shopiku.util.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {

    private val _loginState = MutableStateFlow<UiState<String>?>(null)
    val loginState: StateFlow<UiState<String>?> = _loginState

    private val _registerState = MutableStateFlow<UiState<String>?>(null)
    val registerState: StateFlow<UiState<String>?> = _registerState

    fun login(email: String, password: String) {
        viewModelScope.launch {
            _loginState.value = UiState.Loading
            try {
                val token = MockRepository.login(email, password)
                _loginState.value = UiState.Success(token)
            } catch (e: Exception) {
                _loginState.value = UiState.Error(e.message ?: "Login gagal")
            }
        }
    }

    fun register(name: String, email: String, password: String) {
        viewModelScope.launch {
            _registerState.value = UiState.Loading
            try {
                val token = MockRepository.register(name, email, password)
                _registerState.value = UiState.Success(token)
            } catch (e: Exception) {
                _registerState.value = UiState.Error(e.message ?: "Registrasi gagal")
            }
        }
    }

    fun resetStates() {
        _loginState.value = null
        _registerState.value = null
    }
}
