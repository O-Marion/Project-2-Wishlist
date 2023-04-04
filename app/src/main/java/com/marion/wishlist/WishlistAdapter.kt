package com.marion.wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WishlistAdapter(private val wishlists: List<WishList>): RecyclerView.Adapter<WishlistAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val contactView = inflater.inflate(R.layout.wishlist_item, parent, false)
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val wishList = wishlists.get(position)
        holder.priceTextView.text = wishList.name
        holder.nameTextView.text = wishList.price
        holder.urlTextView.text = wishList.url

    }

    override fun getItemCount(): Int {
        return wishlists.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val nameTextView = itemView.findViewById<TextView>(R.id.tv_name)
        val priceTextView = itemView.findViewById<TextView>(R.id.tv_price)
        val urlTextView  = itemView.findViewById<TextView>(R.id.tv_url)
    }

}