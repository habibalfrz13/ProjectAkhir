package com.habib.projectakhirv4

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class KategoriActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kategori)

        val imageViewPesawat: ImageView = findViewById(R.id.imageView18)
        val imageViewSepatu: ImageView = findViewById(R.id.imageView21)
        val imageViewTas: ImageView = findViewById(R.id.imageView23)

        imageViewPesawat.setOnClickListener {
            val intent = Intent(this@KategoriActivity, CraftActivity::class.java)
            startActivity(intent)
        }

        imageViewSepatu.setOnClickListener {
            val intent = Intent(this@KategoriActivity, CraftActivity::class.java)
            startActivity(intent)
        }

        imageViewTas.setOnClickListener {
            val intent = Intent(this@KategoriActivity, CraftActivity::class.java)
            startActivity(intent)
        }
    }
}
