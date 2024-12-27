package com.example.lab4_kotlin

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import android.widget.PopupMenu
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.lab4_kotlin.produitsA.produitActivity


class AcceuilMetro : AppCompatActivity() {

    private lateinit var imageSlider: ImageSlider
    private lateinit var ImageList: ArrayList<SlideModel>
    private lateinit var btn : Button

    private lateinit var intent : Intent;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_acceuil_metro)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val dbref = TableDataGateway(this, "metrodb")
        dbref.insertcategory(0, "Fruits")
        dbref.insertcategory(1, "Légumes")
        dbref.insertcategory(2, "Produits laitiers")
        dbref.insertcategory(3, "Viandes")
        dbref.insertcategory(4, "Poissons")
        dbref.insertcategory(5, "Produits de la mer")

        btn = findViewById(R.id.btnChoix)
        var nom = dbref.getcategory()

        btn.setOnClickListener { view ->
            val popupMenu = PopupMenu(this, view )
            val menu: Menu = popupMenu.menu

            nom.forEachIndexed { index, element ->
                menu.add(0, index, 0, element)
            }

            popupMenu.setOnMenuItemClickListener{item ->
                var nom = item.title.toString()
                intent = Intent(this, produitActivity::class.java)
                intent.putExtra("nomKey", nom)
                startActivity(intent)
                true
            }

            popupMenu.show();
        }


        imageSlider = findViewById(R.id.imageSlider)
        ImageList = ArrayList()

        ImageList.add( SlideModel(R.drawable.metroe,"Metro", ScaleTypes.CENTER_CROP))
        ImageList.add( SlideModel(R.drawable.metroa,"Metro", ScaleTypes.CENTER_CROP))
        ImageList.add( SlideModel(R.drawable.metrob,"Metro", ScaleTypes.CENTER_CROP))
        ImageList.add( SlideModel(R.drawable.metroc,"Metro", ScaleTypes.CENTER_CROP))
        ImageList.add( SlideModel(R.drawable.metroh,"Metro", ScaleTypes.CENTER_CROP))
        ImageList.add( SlideModel(R.drawable.metroi,"Metro", ScaleTypes.CENTER_CROP))
        ImageList.add( SlideModel(R.drawable.metrok,"Metro", ScaleTypes.CENTER_CROP))

        imageSlider.setImageList(ImageList)



    }

}