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

class MetalsFragment: Fragment() {

    private val viewModel: HomeViewModel by activityViewModels()

    private lateinit var rcvMetals: RecyclerView
    lateinit var metalAdapter: MetalAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_metal, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        setupBehavior()
        setupObservers()
        viewModel.getMetals()
    }

    private fun setupView() {
        view?.let {
            rcvMetals = it.findViewById(R.id.rcVwMetal)
        }
    }

    private fun setupBehavior() {

    }

    private fun setupObservers() {
        viewModel.metals.observe(viewLifecycleOwner) {
            rcvMetals.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(requireContext())
                adapter = MetalAdapter(it)
            }
        }
    }

    companion object {
        fun newInstance() = MetalsFragment()
    }
}