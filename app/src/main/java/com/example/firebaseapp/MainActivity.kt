package com.example.firebaseapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database
import com.google.firebase.database.getValue
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView: TextView = findViewById(R.id.textView)


        val db = Firebase.firestore

        val users_collection = db.collection("Users")

        val user1 = hashMapOf(
            "name" to "jack",
            "lname" to "reacher",
            "born" to "1992"
        )
        val user2 = hashMapOf(
            "name" to "jaohk",
            "lname" to "reek",
            "born" to "1991"
        )

        //create/add doc to collection
        users_collection.document("user1").set(user1)
        users_collection.document("user2").set(user2)


        //read
        val docRef = db.collection("Users").document("user1")

        docRef.get().addOnSuccessListener {
            document->
                if(document!=null){
                    textView.text = "${document.data}"
                }
        }



        /**
        //RealTime db Reference - Simple value
        //https://fir-kotlin-bff91-default-rtdb.europe-west1.firebasedatabase.app/
        database = Firebase.database("https://fir-kotlin-bff91-default-rtdb.europe-west1.firebasedatabase.app").reference

        //Write data  to Firebase
        database.child("price").setValue("12312 $")

        //reading data
        val postListener = object  : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val gold_price = snapshot.value

                textView.text = gold_price.toString()
            }

            override fun onCancelled(error: DatabaseError) {

            }

        }

        database.child("price").addValueEventListener(postListener)
        **/


/**
        //Custom objects - Firebase realtime db

        //RealTime db Reference - Simple value
        //https://fir-kotlin-bff91-default-rtdb.europe-west1.firebasedatabase.app/
        database = Firebase.database("https://fir-kotlin-bff91-default-rtdb.europe-west1.firebasedatabase.app").reference

        //writing
        val user1 : User = User("Jack","1234")

        database.child("Users").setValue(user1)

        //Reading
        val pe = object  : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val u1 : User? = snapshot.getValue<User>()

                if (u1 != null) {
                    textView.text = "Username: " + u1.username.toString() + "\nPassword: " + u1.password.toString()
                }

            }

            override fun onCancelled(error: DatabaseError) {

            }

        }

        database.child("Users").addValueEventListener(pe)
**/
    }
}