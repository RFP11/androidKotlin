package com.example.ujian_praktek_kotlin_muhammad_rafly_pratama

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val btnEksekusi = findViewById<Button>(R.id.eksekusi2)
        var nilai1 = findViewById<EditText>(R.id.Nilai1)
        var nilai2 = findViewById<EditText>(R.id.Nilai2)
        val praktek3 = findViewById<Button>(R.id.praktek31)
        var keterangan = findViewById<TextView>(R.id.Keterangan)
        var jumlah = findViewById<TextView>(R.id.Jumlah)
        val menu = findViewById<Button>(R.id.menu)

        menu!!.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        praktek3!!.setOnClickListener{
            val intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
        }

        btnEksekusi!!.setOnClickListener {
            try {
                val umum = nilai1.text.toString().toInt()
                val produktif = nilai2.text.toString().toInt()
                val total = (umum + produktif)/2

                jumlah.setText(total.toString())

                when {
                    total > 100 -> {
                        Toast.makeText(this, "Input tidak valid!", Toast.LENGTH_SHORT).show()
                    }
                    total > 85 -> {
                        keterangan.setText("A")
                    }
                    total >= 70 && total <= 85 -> {
                        keterangan.setText("B")
                    }
                    total >= 60 && total <= 70 -> {
                        keterangan.setText("C")
                    }
                    else -> {
                        keterangan.setText("D")
                    }
                }

            }catch (e: java.lang.NumberFormatException){
                Toast.makeText(this, "Input harus berupa bilangan bulat!", Toast.LENGTH_SHORT).show()
            }catch (e: NullPointerException){
                Toast.makeText(this, "Input tidak boleh kosong!", Toast.LENGTH_SHORT).show()
            }
        }

    }
}