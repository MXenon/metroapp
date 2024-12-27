package com.example.lab4_kotlin.cart

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.lab4_kotlin.R
import com.example.lab4_kotlin.produitsA.produit
import kotlin.time.times

class cartAdapter(context: Context, produitList: List<produit>, layoutId: Int) : ArrayAdapter<produit>(context, layoutId, produitList) {

    private var context: Context
    private var produitList: List<produit>
    private var layoutId: Int

    private var quantity = 0;

    init {
        this.context = context
        this.produitList = produitList
        this.layoutId = layoutId
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var p = produitList[position];
        var v = View.inflate(context, layoutId, null);

        var prixCart = v.findViewById<TextView>(R.id.prixC);
        var imageCart = v.findViewById<ImageView>(R.id.imageC);

        var quantiteCart = v.findViewById<TextView>(R.id.quantite);
        var btndownCart = v.findViewById<Button>(R.id.btndown);
        var btnupCart = v.findViewById<Button>(R.id.btnup);
        var trashbtn = v.findViewById<Button>(R.id.trashbtn);

        btndownCart.isFocusable= true
        btnupCart.isFocusable= true
        trashbtn.isFocusable= true

        btndownCart.setOnClickListener {
            if (quantity > 0) {
                quantity--
                quantiteCart.text = quantity.toString()
            }
        }

        btnupCart.setOnClickListener {
            quantity++
            quantiteCart.text = quantity.toString()
        }


        prixCart.text = p.getPrix().toString();
        Glide.with(getContext()).load(p.getImageurl()).into(imageCart);

        return v;
    }
}