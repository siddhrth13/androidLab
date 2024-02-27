package com.example.feedback

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var recv_name = intent.getStringExtra("sent_name")
        var recv_gender = intent.getStringExtra("sent_gender")

        var tview1 = findViewById<TextView>(R.id.textView)
        tview1.text = recv_name

        var tview2 = findViewById<TextView>(R.id.textView3)
        tview2.text = recv_gender

        var users = arrayOf("Ronaldo", "Lewis", "Virat", "LeBron")
        val dropdown = findViewById<Spinner>(R.id.spinner)

        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, users)
        dropdown.adapter = arrayAdapter

        dropdown.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                // The item at position 'position' is selected
                Toast.makeText(
                    this@MainActivity2,
                    "Item Clicked: " + users[position],
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    }
}
