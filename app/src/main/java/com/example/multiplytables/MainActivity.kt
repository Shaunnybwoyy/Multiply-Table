package com.example.multiplytables

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.jvm.java

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //Created variables to hold UI elements
        val multiplyBtn = findViewById<Button>(R.id.multiplyBtn)
        val numInput = findViewById<EditText>(R.id.numTxtInput)

        //Created a set click listener to listen for the button click
        multiplyBtn.setOnClickListener {
            /*Created an intent to switch between pages (switching from main page to table
            display page*/

            //create the explicit intent
             val Intent = Intent(this, TableDisplay ::class.java)
            // add the table number to the intent
            intent.putExtra("tableNumber",
        }   startActivity(intent )
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.numTxtInput)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}