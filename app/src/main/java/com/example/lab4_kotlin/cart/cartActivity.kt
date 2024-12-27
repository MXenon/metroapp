package com.example.lab4_kotlin.cart

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lab4_kotlin.R
import com.example.lab4_kotlin.produitsA.produit

class cartActivity : AppCompatActivity() {

    private lateinit var listvw : ListView
    private lateinit var i : Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cart)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        i = intent;
        var sproducts = i.getSerializableExtra("selectedProducts") as List<produit>
        listvw = findViewById(R.id.list);
        var adap = cartAdapter(this, sproducts ,R.layout.templatecart);
        listvw.adapter = adap;

    }
}