package com.example.exam.ui.main

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.exam.R
import com.example.exam.ui.home.HomeActivity
import com.example.exam.viewModels.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var edtUser: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnLogin: Button

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setupView()
        setupBehavior()
        viewModel.test()
    }

    private fun setupView() {
        edtUser = findViewById<EditText>(R.id.edtTxtUser)
        edtPassword = findViewById(R.id.edtTxtPassword)
        btnLogin = findViewById(R.id.btnLogin)
    }

    private fun setupBehavior() {
        btnLogin.setOnClickListener {
            val isUserEntryCorrect = edtUser.text.isEmpty().not()

            val emailEntry = edtPassword.text
            var userLengthCondition = false
            var passwordNumberCondition = false

            if (emailEntry.contains("[0-9]".toRegex())) {
                passwordNumberCondition = true
            }

            var count = 0
            emailEntry.forEach {
                if (it.isLetter()) {
                    count++
                }
            }

            if (count >= 7) {
                userLengthCondition = true
            }

            if (isUserEntryCorrect && (userLengthCondition && passwordNumberCondition)) {
                startActivity(Intent(this, HomeActivity::class.java))
            } else {
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
            }
        }
    }
}