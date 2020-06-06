package com.marioapps.locatemenow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db: FirebaseFirestore = FirebaseFirestore.getInstance()

        val et_latitude: EditText = findViewById(R.id.et_latitude)
        val et_longitude: EditText = findViewById(R.id.et_longitude)

        val button: Button = findViewById(R.id.btn_send)
        button.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
//                Toast.makeText(this@MainActivity, "puchado", Toast.LENGTH_SHORT).show()
                val location = hashMapOf(
                    "latitude" to et_latitude.text.toString(),
                    "longitude" to et_longitude.text.toString()
                )

                db.collection("location").document("current-location")
                    .set(location)
                    .addOnSuccessListener { Toast.makeText(this@MainActivity, "vientos", Toast.LENGTH_SHORT).show() }
                    .addOnFailureListener {e -> Toast.makeText(this@MainActivity, e.message, Toast.LENGTH_SHORT).show()}
            }
        })


    }
}
