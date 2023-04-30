package com.example.firebasechat.firebase


import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.example.firebasechat.model.UserModel


fun GetUsers() : SnapshotStateList<UserModel> {
    val _users = mutableStateListOf<UserModel>()

    try {
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("users")

        myRef.addChildEventListener(object : ChildEventListener {
            override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                val _value = snapshot.getValue(UserModel::class.java)
                if (_value != null) {
                    _users.add(_value)
                    println("name = ${_value.name}")
                }

            }

            override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {

            }

            override fun onChildRemoved(snapshot: DataSnapshot) {

            }

            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {

            }

            override fun onCancelled(error: DatabaseError) {

            }

        })

    } catch (e: Exception) {
        println("Error: ${e.message}")
        Log.e("ERROR_FIREBASE", e.message.toString())
    }

    return _users

}