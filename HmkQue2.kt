package com.example.hmkque

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val btn2 = findViewById<Button>(R.id.button2)
        val fan = findViewById<CheckBox>(R.id.c1)
        val light = findViewById<CheckBox>(R.id.c2)
        val bulb = findViewById<CheckBox>(R.id.c3)

        var total_quan = 0

        var display_string = "Items Selected: "

        btn2.setOnClickListener {
            if(fan.isChecked){
                var fan_q = findViewById<EditText>(R.id.q1)
                var no_of_fans = fan_q.text.toString().toInt()

                var fan_p = findViewById<EditText>(R.id.p1)
                var fan_price = fan_p.text.toString().toInt()

                total_quan += (no_of_fans * fan_price)
                display_string +=  "Fan "
            }
            if(light.isChecked){
                var light_q = findViewById<EditText>(R.id.q2)
                var no_of_lights = light_q.text.toString().toInt()

                var light_p = findViewById<EditText>(R.id.p2)
                var light_price = light_p.text.toString().toInt()

                display_string += "Light "
                total_quan += (no_of_lights * light_price)
            }
            var total_string = "your total is: " + total_quan.toString()
            display_string += total_string

            Toast.makeText(this, display_string, Toast.LENGTH_LONG).show()
        }


    }
}
