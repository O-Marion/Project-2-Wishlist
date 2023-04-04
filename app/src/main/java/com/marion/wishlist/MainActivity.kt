package com.marion.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private var wishList: MutableList<WishList> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val wishListRv = findViewById<RecyclerView>(R.id.rv_wishlist)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        val etItemName = findViewById<EditText>(R.id.et_name)
        val etPrice = findViewById<EditText>(R.id.et_price)
        val etUrl = findViewById<EditText>(R.id.et_url)
        val adapter = WishlistAdapter(wishList)
        wishListRv.adapter = adapter
        wishListRv.layoutManager = LinearLayoutManager(this)

        btnSubmit.setOnClickListener {

            if (etItemName.text.toString().isEmpty()){
                Toast.makeText(this,"Wishlisht item name cannot be empty",Toast.LENGTH_SHORT).show()
            }else if (etPrice.text.toString().isEmpty()){
                Toast.makeText(this,"Wishlisht item price cannot be empty",Toast.LENGTH_SHORT).show()
            }else if(etUrl.text.toString().isEmpty()){
                Toast.makeText(this,"Wishlisht item url cannot be empty",Toast.LENGTH_SHORT).show()
            }else{
                val wishListItem = WishList(
                    name = etItemName.text.toString(),
                    price = etPrice.text.toString(),
                    url = etUrl.text.toString()
                )
                wishList.add(wishListItem)
                (wishListRv.adapter as WishlistAdapter).notifyDataSetChanged()
                etItemName.setText("")
                etPrice.setText("")
                etUrl.setText("")
            }
        }

    }
}