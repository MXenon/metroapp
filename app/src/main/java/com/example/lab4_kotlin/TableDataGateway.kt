package com.example.lab4_kotlin

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.lab4_kotlin.produitsA.produit

class TableDataGateway(context: Context?,name: String) : SQLiteOpenHelper(context, name, null, 1) {

    private lateinit var db: SQLiteDatabase

    private var context: Context? = null
    private var name: String? = "metrodb"

    init {

        this.context = context
        this.name = name
    }

    override fun onCreate(db: SQLiteDatabase?) {
        var Query1 = "create table categories(id integer primary key autoincrement, nom text)"
        var Query2 = "create table produits(id integer primary key autoincrement, imageUrl text, prix number, categorie text, description text)"
        db?.execSQL(Query1)
        db?.execSQL(Query2)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

    fun insertcategory(id: Int, nom: String): Long {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put("id", id)
            put("nom", nom)
        }
        return db.insert("categories", null, values)
    }
    fun insertproduit(id: Int, ImageUrl: String, prix: Double, categorie: String, description: String): Long {

        val db = this.writableDatabase
        val values = ContentValues().apply {
            put("id", id)
            put("imageUrl", ImageUrl)
            put("prix", prix)
            put("categorie", categorie)
            put("description", description)
        }
        return db.insert("produits", null, values)
    }

    fun getcategory(): List<String> {

        val categories = mutableListOf<String>()

        val db = this.readableDatabase
        val cursor = db.rawQuery("select nom from categories", null)
        if (cursor.moveToFirst()) {
            do {
                categories.add(cursor.getString(0))
            } while (cursor.moveToNext())
        }
        cursor.close()
        return categories
    }

    fun getproductByCategory(category: String): List<produit> {
        val products = mutableListOf<produit>()
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT prix,imageUrl,description FROM produits WHERE categorie = ?", arrayOf(category))
        if (cursor.moveToFirst()) {
            do {
                val prix = cursor.getDouble(0)
                val imageUrl = cursor.getString(1)
                val description = cursor.getString(2)
                products.add(produit(prix,category,imageUrl,description))
            } while (cursor.moveToNext())
        }
        cursor.close()
        return products
    }
}
