package com.example.heechintong

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.heechintong.databinding.ActivityDashboardBinding

import com.google.firebase.auth.FirebaseAuth
class DashboardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDashboardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonLogout.setOnClickListener {
            performLogout()
        }
    }

    private fun performLogout() {
        FirebaseAuth.getInstance().signOut();
    }

}