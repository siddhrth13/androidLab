package com.example.feedback

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btn = findViewById<Button>(R.id.button01)
        val intent = Intent(this,MainActivity2::class.java)

        btn.setOnClickListener {
            var name = findViewById<EditText>(R.id.editTextText)

            var male = findViewById<RadioButton>(R.id.radioButton3)
            var female = findViewById<RadioButton>(R.id.radioButton4)

            var nm = name.text.toString()
            intent.putExtra("sent_name",nm)
            if(male.isChecked){
                var m = male.text.toString()
                intent.putExtra("sent_gender",m)
                startActivity(intent)
            }
            else if(female.isChecked){
                var f = female.text.toString()
                intent.putExtra("sent_gender",f)
                startActivity(intent)
            }
            else{
                val builder: AlertDialog.Builder = AlertDialog.Builder(this@MainActivity)
                // Set the message show for the Alert time
                builder.setMessage("Please Enter Gender ?")

                // Set Alert Title
                builder.setTitle("Alert !")
                // Set Cancelable false for when the user clicks on the outside the Dialog Box then it will remain show
                builder.setCancelable(false)
                // Set the positive button with yes name Lambda OnClickListener method is use of DialogInterface interface.
                builder.setPositiveButton("Close App",
                    DialogInterface.OnClickListener { dialog: DialogInterface?, which: Int ->
                        // When the user click yes button then app will close
                        finish()
                    } as DialogInterface.OnClickListener)
                // Set the Negative button with No name Lambda OnClickListener method is use of DialogInterface interface.
                builder.setNegativeButton("Ok",
                    DialogInterface.OnClickListener { dialog: DialogInterface, which: Int ->
                        // If user click no then dialog box is canceled.
                        dialog.cancel()
                    } as DialogInterface.OnClickListener)
                // Create the Alert dialog
                val alertDialog: AlertDialog = builder.create()
                // Show the Alert Dialog box
                alertDialog.show()
            }
        }
    }
}
