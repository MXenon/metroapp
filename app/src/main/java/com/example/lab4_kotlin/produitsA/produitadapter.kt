package com.example.lab4_kotlin.produitsA

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.lab4_kotlin.R

class produitadapter(context: Context, produitList: List<produit>, layoutId: Int) : ArrayAdapter<produit>(context, layoutId, produitList) {

    private var context: Context
    private var produitList: List<produit>
    private var layoutId: Int

    private val cartList = mutableListOf<produit>();

    init {
        this.context = context
        this.produitList = produitList
        this.layoutId = layoutId
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var p = produitList[position];
        var v = View.inflate(context, layoutId, null);

        var prix = v.findViewById<TextView>(R.id.prixT);
        var descrip = v.findViewById<TextView>(R.id.descripT);
        var imageU = v.findViewById<ImageView>(R.id.imageT);
        var AjoutBtn = v.findViewById<Button>(R.id.ajoutT);
        AjoutBtn.isFocusable= true

        AjoutBtn.setOnClickListener {
            var produit = produitList[position];
            if(!cartList.contains(produit)){
                cartList.add(produit);
                Toast.makeText(context, "Produit ajouté au panier : cart", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(context, "Produit déjà ajouté au panier", Toast.LENGTH_SHORT).show();
            }
        }


        prix.text = p.getPrix().toString();
        descrip.text = p.getDescriptiom();
        Glide.with(getContext()).load(p.getImageurl()).into(imageU);


        return v;
    }

    fun getCartList(): List<produit> {
        return cartList
    }
}
