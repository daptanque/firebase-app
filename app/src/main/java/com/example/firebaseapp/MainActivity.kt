package com.example.firebaseapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.database
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //RealTime db Reference
        //https://fir-kotlin-bff91-default-rtdb.europe-west1.firebasedatabase.app/
        database = Firebase.database("https://fir-kotlin-bff91-default-rtdb.europe-west1.firebasedatabase.app").reference

        //Write data  to Firebase
        database.child("price").setValue("12312 $")

    }
}