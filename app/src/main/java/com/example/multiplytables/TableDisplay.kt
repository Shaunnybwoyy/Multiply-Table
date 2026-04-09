package com.example.multiplytables

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TableDisplay : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_table_display)

        //assigning data from main page to variable
        val bundle: Bundle = intent.extras

        val tableSpring: String? = bundle?.getString( key = "tableNumber")

        //converting the string back into a number ready for multiplication
        val tableNumber = tableSpring!!.toInt()

        //display the heading so we can see the value in action //
        val multiplyTable = findViewById<TextView>(R.id.tableDisplayTxt)
        var timesDisplay: String ="$tableNumber x table\n\n"

        //creating counter for while loop
        var count = 1

        //
        multiplyTable.text = timesDisplay

        while (count<=10){


              //Adding a continue
              if (count ==4){
                  count++
                  continue

                  //example: user enters 5 and count is SO: 5 x 1 = 5 (answer)
            val answer = tableNumber * count
            /*displays as:
            5 x tables


             5 x 1 = 5
             */
             timesDisplay += "$tableNumber x $count = ${answer}\n"
             count++              //update the control variable
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}