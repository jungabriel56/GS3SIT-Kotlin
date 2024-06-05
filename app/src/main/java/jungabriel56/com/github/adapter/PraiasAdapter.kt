package jungabriel56.com.github.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import jungabriel56.com.github.R
import jungabriel56.com.github.model.PraiaModel

class PraiasAdapter : RecyclerView.Adapter<PraiasAdapter.ItemViewHolder>() {

    private val praias = mutableListOf<PraiaModel>()

    fun addPraia(newPraia: PraiaModel) {
        praias.add(newPraia)
        notifyDataSetChanged()
    }


    fun removePraia(praia: PraiaModel) {
        praias.remove(praia)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.praia_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int = praias.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = praias[position]
        holder.bind(item)
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView = view.findViewById<TextView>(R.id.textViewPraia)
        val button = view.findViewById<ImageButton>(R.id.imageButton)
        fun bind(praia: PraiaModel) {
            textView.text = praia.name
            button.setOnClickListener {
                praia.onRemove(praia)
            }
        }
    }


}