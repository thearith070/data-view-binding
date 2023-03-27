package com.sample.databinding

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val emails = mutableListOf("test@gmail.com", "test2@gmail.com", "test3@gmail.com")
    private val passwords = mutableListOf("123", "12345", "123456789")

    val message: MutableLiveData<String> = MutableLiveData()
    val email: MutableLiveData<String> = MutableLiveData()
    val password: MutableLiveData<String> = MutableLiveData()

    fun doLogin() {
        val email = this.email.value
        val password = this.password.value

        message.value = when {
            email.isNullOrEmpty() -> {
                "Please input Email"
            }
            password.isNullOrEmpty() -> {
                "Please input Password"
            }
            else -> {
                if (emails.contains(email) && passwords.contains(password)) {
                    "Login successfully!!"
                } else {
                    "Email or Password is incorrect"
                }
            }
        }
    }
}