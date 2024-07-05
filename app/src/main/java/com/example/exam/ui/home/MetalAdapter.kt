package com.example.exam.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.exam.R
import com.example.exam.model.MetalModel
import com.example.exam.model.ProcessModel

class MetalAdapter(processes: List<MetalModel>): RecyclerView.Adapter<MetalAdapter.MetalViewHolder>() {

    private var elements = processes

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MetalViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MetalViewHolder(layoutInflater.inflate(R.layout.metal_item, parent, false))
    }

    override fun onBindViewHolder(holder: MetalViewHolder, position: Int) {
        val item = elements[position]
        holder.bind(item)
    }

    override fun getItemCount() = elements.size

    class MetalViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private var imgVwExternal: ImageView = view.findViewById(R.id.imgVwExternal)
        private var txtVwName: TextView = view.findViewById(R.id.txtVwName)
        private var txtVwDesc: TextView = view.findViewById(R.id.txtVwDesc)

        fun bind(metal: MetalModel) {
            txtVwName.text = metal.name
            txtVwDesc.text = metal.description

            metal.externalUse?.let {
                imgVwExternal.setImageResource(
                    if (it == 0) {
                        R.drawable.red_background
                    } else {
                        R.drawable.green_background
                    }
                )
            }
        }
    }

    fun setItems(processes: List<MetalModel>) {
        elements = processes
        notifyDataSetChanged()
    }
}