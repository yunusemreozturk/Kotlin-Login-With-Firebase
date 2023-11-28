package com.example.myapplication.util

class Validators {
    companion object {
        fun isValidPassword(password: String): String? {
            return if (password.length < 8) "Parola 8'den büyük olmalıdır"
            else null
        }

        fun isValidEmail(email: String): String? {
            val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$"

            val isValid = email.matches(emailRegex.toRegex())

            return if (!isValid) "Email adresinizde bir hata var" else null
        }
    }

}