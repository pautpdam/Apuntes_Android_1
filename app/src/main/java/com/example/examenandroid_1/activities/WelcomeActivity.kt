package com.example.examenandroid_1.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.examenandroid_1.R
import com.example.examenandroid_1.fragments.WelcomeFragment

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val name = intent.getStringExtra("name")
        val lastName = intent.getStringExtra("lastName")

        val welcomeFragment = WelcomeFragment.newInstance(name?: "Null", lastName?: "Null")

        supportFragmentManager.beginTransaction()
            .replace(R.id.welcomeFragmentContainer, welcomeFragment)
            .commit()
    }
}