package com.example.hmkque

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val arrayAdapter: ArrayAdapter<*>
        val users = arrayOf(
            "Kitchen", "Hall", "Master-Bedroom",
            "Bathroom", "Children-Bedroom"
        )
        val btn = findViewById<Button>(R.id.button)

        // access the listView from xml file
        var mListView = findViewById<ListView>(R.id.roomList)
        arrayAdapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1, users)
        mListView.adapter = arrayAdapter

        mListView.setOnItemClickListener { AdapterView, view, i, id ->
            Toast.makeText(this, "Section Selected: "+users[i], Toast.LENGTH_SHORT).show()
        }

        val intent = Intent(this,MainActivity2::class.java)
        btn.setOnClickListener {
            val builder = AlertDialog.Builder(this)

            // Set the message show for the Alert time
            builder.setMessage("Do u want to submit ?")

            // Set Alert Title
            builder.setTitle("Alert !")

            // Set Cancelable false for when the user clicks on the outside the Dialog Box then it will remain show
            builder.setCancelable(false)

            // Set the positive button with yes name Lambda OnClickListener method is use of DialogInterface interface.
            builder.setPositiveButton("Yes") {
                // When the user click yes button then app will close
                    dialog, which -> startActivity(intent)
            }

            // Set the Negative button with No name Lambda OnClickListener method is use of DialogInterface interface.
            builder.setNegativeButton("No") {
                // If user click no then dialog box is canceled.
                    dialog, which -> dialog.cancel()
            }

            // Create the Alert dialog
            val alertDialog = builder.create()
            // Show the Alert Dialog box
            alertDialog.show()
        }
    }
}
