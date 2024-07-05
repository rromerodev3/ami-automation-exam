package com.example.exam.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.exam.R
import com.example.exam.viewModels.HomeViewModel

class ProcessFragment: Fragment() {

    private val viewModel: HomeViewModel by activityViewModels()
    private lateinit var rcvProcess: RecyclerView
    lateinit var processAdapter: ProcessAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_process, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        setupBehavior()
        setupObservers()
        viewModel.getProcess()
    }

    private fun setupView() {
        view?.let {
            rcvProcess = it.findViewById(R.id.rcVwProcess)
        }
    }

    private fun setupBehavior() {

    }

    private fun setupObservers() {
        viewModel.processes.observe(viewLifecycleOwner) {
            rcvProcess.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(requireContext())
                adapter = ProcessAdapter(it)
            }
        }
    }

    companion object {
        fun newInstance() = ProcessFragment()
    }
}