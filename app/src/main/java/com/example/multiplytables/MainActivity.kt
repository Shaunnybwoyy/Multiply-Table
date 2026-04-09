package com.example.multiplytables

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val multiplyBtn = findViewById<Button>(R.id.multiplyBtn)
        val numInput = findViewById<EditText>(R.id.editTextNumber)

        //Created a set click listener to listen for the button click
        multiplyBtn.setOnClickListener {
            val tableNumber = numInput.text.toString()
            
            if (tableNumber.isNotEmpty()) {
                /*Created an intent to switch between pages (switching from main page to table display page*/
                val intent = Intent(this, TableDisplay::class.java)
                // add the table number to the intent
                intent.putExtra("tableNumber", tableNumber)
                startActivity(intent)
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.numTxtInput)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}