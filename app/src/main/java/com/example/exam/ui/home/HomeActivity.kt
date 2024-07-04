package com.example.exam.ui.home

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.exam.R
import com.example.exam.viewModels.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private val viewModel by viewModels<HomeViewModel>()
    private lateinit var rcvProcess: RecyclerView
    lateinit var processAdapter: ProcessAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.fragment_process)

        setupView()
        setupBehavior()
        setupObservers()
        viewModel.loadData()
    }

    private fun setupObservers() {
        viewModel.elements.observe(this) {
            rcvProcess.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(this@HomeActivity)
                adapter = ProcessAdapter(it)
            }
        }
    }

    private fun setupView() {
        rcvProcess = findViewById(R.id.rcVwProcess)
    }

    private fun setupBehavior() {

    }
}