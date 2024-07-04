package com.example.exam.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.exam.R
import com.example.exam.model.ProcessModel

class ProcessAdapter(processes: List<ProcessModel>): RecyclerView.Adapter<ProcessAdapter.ProcessViewHolder>() {

    private var elements = processes

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProcessViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ProcessViewHolder(layoutInflater.inflate(R.layout.process_item, parent, false))
    }

    override fun onBindViewHolder(holder: ProcessViewHolder, position: Int) {
        val item = elements[position]
        holder.bind(item)
    }

    override fun getItemCount() = elements.size

    class ProcessViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private var txtVwProcess: TextView = view.findViewById(R.id.txtVwId)
        private var txtVwComment: TextView = view.findViewById(R.id.txtVwComment)
        private var txtVwDate: TextView = view.findViewById(R.id.txtVwDate)

        fun bind(process: ProcessModel) {
            txtVwProcess.text = process.ProcessId
            txtVwComment.text = process.Comment
            txtVwDate.text = process.TimeFinished
        }
    }

    fun setItems(processes: List<ProcessModel>) {
        elements = processes
        notifyDataSetChanged()
    }
}