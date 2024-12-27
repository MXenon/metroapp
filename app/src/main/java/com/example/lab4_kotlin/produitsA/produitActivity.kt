package com.example.lab4_kotlin.produitsA

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lab4_kotlin.R
import com.example.lab4_kotlin.TableDataGateway
import com.example.lab4_kotlin.cart.cartActivity
import java.util.ArrayList

class produitActivity : AppCompatActivity() {

    private lateinit var nomcatgry : TextView;
    private lateinit var i : Intent;
    private lateinit var inten : Intent;
    private lateinit var listV : ListView;

    private lateinit var cbtn : Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_produit)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        nomcatgry = findViewById(R.id.nomcatgry);
        cbtn = findViewById(R.id.cartbtn);
        listV = findViewById(R.id.list);

        i = intent;
        nomcatgry.text = i.getStringExtra("nomKey");

        val dbref1 = TableDataGateway(this, "metrodb")

        dbref1.insertproduit(0,"https://www.cuisinelangelique.com/infotheque/wp-content/uploads/2023/03/banane-1a.jpg",10000.0,"Fruits","Banane douce")
        dbref1.insertproduit(1,"https://d18sgtr99mvn1i.cloudfront.net/carottes-rouges-bio-1666814377.jpeg",20000.0,"Légumes","Carotte rouge")
        dbref1.insertproduit(2,"https://www.hsnstore.fr/blog/wp-content/uploads/sites/4/2021/01/produits-laitiers-hsn.jpg",30000.0,"Produits laitiers","Yaourt nature")
        dbref1.insertproduit(3,"https://www.bignalet.com/44-large_default/steak-de-boeuf-de-chalosse-igp.jpg?20230322092308",40000.0,"Viandes","Steak de boeuf")
        dbref1.insertproduit(4,"https://img.passeportsante.net/1200x675/2021-05-03/i102115-orange-nu.webp",50000.0,"Fruits","Les oranges")
        dbref1.insertproduit(5,"https://static.mamanpourlavie.com/uploads/images/articles.cache/2008/02/02/file_main_image_1456_1_tout_savoir_purees_viande_1456_01_1500X1000_cache_640x360.jpg",100000.0,"Viandes","riches en proteines")
        dbref1.insertproduit(6,"https://labelleassiette.fr/wp-content/uploads/2024/05/fruit-en-s-liste-des-fruits-qui-commencent-par-s.jpg",90000.0,"Fruits","Bon et claire pour la sante")
        dbref1.insertproduit(7,"https://cdn.britannica.com/59/160759-050-AC4A0FDE/Guar-cluster-beans-India.jpg",80000.0,"Légumes","Piments verts tres bon ")
        dbref1.insertproduit(8,"https://www.lactalisfoodservice.fr/app/uploads/2022/09/ambiance-1-restauration-gastronomique-hd-1440x711.jpg",70000.0,"Produits laitiers","Fromage tres bon et vif")
        dbref1.insertproduit(9,"https://www.luximer.com/img/cms/Saumon1.jpg",60000.0,"Poissons","Capitaines")
        dbref1.insertproduit(10,"https://mapoissonniere.fr/87-home_default/saumon-entier-la-piece-de-3kg.jpg",55000.0,"Poissons","Poissons de carte")
        dbref1.insertproduit(11,"https://www.jaimefruitsetlegumes.ca/wp-content/uploads/2019/10/cerises-scaled-e1647012719735.jpg",51000.0,"Fruits","Cerises de bon gout")
        dbref1.insertproduit(12,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT9jrADie1vpjUgrSgDlf6f_RulwK1Jh-M6Vg&s",45000.0,"Viandes","Porc et bon")
        dbref1.insertproduit(13,"https://www.pourquoidocteur.fr/media/article/ggl1200_istock-802266868-plateresca-bol-brocolis-1582556122.jpg",46000.0,"Légumes","Brocoli")
        dbref1.insertproduit(14,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ4eqkin58nH5VSeaORODAMBKVZTn6SDGQUBg&s",980000.0,"Produits de la mer","Huitre de mer")
        dbref1.insertproduit(15,"https://www.lacrieedacote.fr/wp-content/uploads/2021/03/crustaces-crevettes-roses-tropicales-3-1200x900.webp",660000.0,"Produits de la mer","Crevettes")
        dbref1.insertproduit(16,"https://www.cuisineactuelle.fr/imgre/fit/~1~cac~2023~07~07~817019ba-cfb2-477f-9498-5e001fa5690d.jpeg/1200x1200/quality/80/crop-from/center/gambas-quel-temps-de-cuisson-faut-il-les-decortiquer-quelle-sauce-pour-les-accompagner.jpeg",760000.0,"Produits de la mer","Gambas")
        dbref1.insertproduit(17,"https://journallesoir.ca/wp-content/uploads/2022/03/277002082_5304011689633371_4415049263441854306_n.jpg",430000.0,"Produits de la mer","Crabes et fruits de la mer")
        dbref1.insertproduit(18,"https://upload.wikimedia.org/wikipedia/commons/thumb/d/d3/Turnip_2622027.jpg/640px-Turnip_2622027.jpg",870000.0,"Légumes","Navet")
        dbref1.insertproduit(19,"https://www.jaimefruitsetlegumes.ca/wp-content/uploads/2019/09/cantaloup-1-scaled-e1642707163718.jpg",990000.0,"Fruits","Cantaloup bonne pour la sante")
        dbref1.insertproduit(20,"https://www.la-viande.fr/sites/default/files/inline-images/cuisson-viande-chevaline.jpg",4320000.0,"Viandes","viande de chevaline ")
        dbref1.insertproduit(21,"https://upload.wikimedia.org/wikipedia/commons/thumb/b/b8/Kiwi_%28Actinidia_chinensis%29_1_Luc_Viatour.jpg/1200px-Kiwi_%28Actinidia_chinensis%29_1_Luc_Viatour.jpg",110000.0,"Fruits","kiwi")
        dbref1.insertproduit(22,"https://images.radio-canada.ca/q_auto,w_900/v1/alimentation/ingredient/1x1/beurre-ingredients-mordu.jpg",950000.0,"Produits laitiers","Vitamines B")
        dbref1.insertproduit(23,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSeoBTJ7Q4urTj_Gi_U-saLOiyIc4au5Q0tjA&s",630000.0,"Fruits","Mangues")


        var produitbycat = dbref1.getproductByCategory(nomcatgry.text.toString())
        var adapter = produitadapter(this, produitbycat, R.layout.template)

        listV.adapter = adapter

        cbtn.setOnClickListener {
            var selectproducts = adapter.getCartList();

             inten = Intent(this, cartActivity::class.java)
            inten.putExtra("selectedProducts", ArrayList(selectproducts))
            startActivity(inten);
        }

    }
}