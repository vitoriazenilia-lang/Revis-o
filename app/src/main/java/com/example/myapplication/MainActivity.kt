package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.InputBinding
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.loginBtn.setOnClickListener{
            val login = binding.loginInput.text.toString().trim()
            val senha = binding.Senhainput.text.toString().trim()

            if (login == "admin" && senha== "1234"){
                val Intent = Intent(this, MainActivity2 :: class.java)
                intent.putExtra("LOGIN_USUARIO", login)
                startActivity(intent)
                finish()
            }else{
                Toast.makeText(this, "Login ou Senha incorretos", Toast.LENGTH_SHORT)
            }
        }
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}