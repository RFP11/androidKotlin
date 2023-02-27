package com.example.ujian_praktek_kotlin_muhammad_rafly_pratama

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnEksekusi = findViewById<Button>(R.id.eksekusi)
        var res = findViewById<TextView>(R.id.hasil)
        var bilangan = findViewById<EditText>(R.id.bilangan)
        val praktek2 = findViewById<Button>(R.id.praktek2)
        val praktek3 = findViewById<Button>(R.id.praktek3)


        btnEksekusi!!.setOnClickListener {
            res.setText("")
            try {
                val operasi = bilangan.text.toString().toInt()
                val stringBuilder = StringBuilder()
                var x = 0

                for (i in 0..operasi step 2) {
                    stringBuilder.append("$i ")
                    x++
                    if (x == 10) {
                        x = 0
                        stringBuilder.append("\n")
                    }
                }

                res.text = stringBuilder.toString()

            }catch (e: java.lang.NumberFormatException){
                Toast.makeText(this, "Input harus berupa bilangan bulat!", Toast.LENGTH_SHORT).show()
            }catch (e: NullPointerException) {
                Toast.makeText(this, "Input tidak boleh kosong!", Toast.LENGTH_SHORT).show()
            }

        }

        praktek2!!.setOnClickListener{
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
        praktek3!!.setOnClickListener{
            val intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
        }
    }
}