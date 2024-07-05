package com.example.exam.ui.home

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.exam.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setupView()
        setupBehavior()
        setupObservers()
    }

    private fun setupObservers() {
    }

    private fun setupView() {
        bottomNavigationView = findViewById(R.id.bottomNavigationView)
    }

    private fun setupBehavior() {
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when(menuItem.itemId) {
                R.id.actionProcess -> {
                    val fragment = ProcessFragment()
                    openFragment(fragment)
                    true
                }
                R.id.actionMetal -> {
                    val fragment = MetalsFragment()
                    openFragment(fragment)
                    true
                }
                else -> false
            }
        }
        bottomNavigationView.selectedItemId = R.id.actionMetal
    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.main_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}