package com.stefano.search.fruitsearch

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import com.stefano.feature_search.R
import kotlinx.android.synthetic.main.item_fruitveg.view.*


import net.stefano.fruitveg.model.FruitVeg



class FruitVegAdapter(private val context: Context) : RecyclerView.Adapter<FruitVegAdapter.FruitVegViewHolder>() {
    override fun onBindViewHolder(holder: FruitVegViewHolder, position: Int) {
        holder?.bind(fruitVegs[position])
    }

    private var fruitVegs: List<FruitVeg> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitVegViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_fruitveg, parent, false)
        return FruitVegViewHolder(v)
    }

    override fun getItemCount(): Int {
        return fruitVegs.size
    }



    fun updateFruitVegs(fruitVegs: List<FruitVeg>) {
        this.fruitVegs = fruitVegs
        notifyDataSetChanged()
    }

    fun deleteAll() {
        this.fruitVegs=emptyList()
        notifyDataSetChanged()
    }


    class FruitVegViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(fruitVeg: FruitVeg) = with(itemView) {
            tfvname.text = fruitVeg.tfvname
            othname.text = fruitVeg.othname

            Picasso.with(itemView.context).load(fruitVeg.imageurl)
                    .placeholder(R.mipmap.ic_launcher_round)// optional
                    .into(fruitimage);

        }

    }

}