package com.example.composereader.screens.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

class LoginScreenViewModel : ViewModel() {
    //    val loadingState = MutableStateFlow(IDLE)
    private val authentication: FirebaseAuth = Firebase.auth
    private val _loading = MutableLiveData(false)
    val loading: LiveData<Boolean> = _loading

    fun userLogin(username: String, email: String, password: String, route: () -> Unit) =
        viewModelScope.launch {
            try {
                authentication.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                    if (it.isSuccessful) {
                        Log.d("Auth", "Login Successful: ${it.result.toString()}")
                        //Navigate to home screen
                        route()
                    } else {
                        Log.d("Auth", "Login Unsuccessful: ${it.result.toString()}")
                    }
                }
            } catch (ex: Exception) {
                Log.d("Auth", "userLogin: ${ex.message}")
            }
        }

    fun userCreate(username: String, email: String, password: String, route: () -> Unit) {
        if (_loading.value == false) {
            _loading.value = true
            Log.d("TEST", "Values [$username] [$email] [$password] ")
            authentication.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                if (it.isSuccessful) {
                    Log.d(
                        "Auth",
                        "Create User Successful: ${it.result.toString()} with userName: $username"
                    )
                    saveUser(username)
                    route()
                    //Navigate to home screen
                } else {
                    Log.d("Auth", "Create User Unsuccessful: ${it.result.toString()}")
                }
                _loading.value = false
            }
        }
    }

    private fun saveUser(username: String) {
        val userId = authentication.currentUser?.uid
        //Initial setup of FireStore... Add test user
        val user: MutableMap<String, Any> = HashMap()

        user["user_id"] = userId.toString()
        user["user_name"] = username

        val db = FirebaseFirestore.getInstance()
        db.collection("users").add(user).addOnSuccessListener {
            Log.d("FireBase", "onCreate ${it.id}")
        }.addOnFailureListener {
            Log.d("FireBase", "Failed to add user ${it}")
        }
        }
    }