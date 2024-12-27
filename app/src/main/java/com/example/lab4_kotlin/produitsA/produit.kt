package com.example.lab4_kotlin.produitsA

import java.io.Serializable

 class produit( prix: Double,  categorie: String,  imageurl : String, descriptiom: String) : Serializable {

    private var prix: Double
    private var categorie: String
    private var imageurl: String
    private var descriptiom: String

    init {
        this.prix = prix
        this.categorie = categorie
        this.imageurl = imageurl
        this.descriptiom = descriptiom
    }



    fun getPrix(): Double {
        return prix
    }

    fun getCategorie(): String {
        return categorie
    }

    fun getImageurl(): String {
        return imageurl
    }
    fun getDescriptiom(): String {
        return descriptiom;
    }

}


