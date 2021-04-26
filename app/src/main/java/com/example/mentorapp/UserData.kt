package com.example.mentorapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.amplifyframework.datastore.generated.model.UserProfile

// a singleton to hold user data (this is a ViewModel pattern, without inheriting from ViewModel)
object UserData {

    private const val TAG = "UserData"

    //
    // observable properties
    //

    // signed in status
    private val _isSignedIn = MutableLiveData<Boolean>(false)
    var isSignedIn: LiveData<Boolean> = _isSignedIn

    fun setSignedIn(newValue : Boolean) {
        // use postvalue() to make the assignation on the main (UI) thread
        _isSignedIn.postValue(newValue)
    }

    // the user
   private val _users = MutableLiveData<MutableList<User>>(mutableListOf())

    private fun <T> MutableLiveData<T>.notifyObserver() {
        this.postValue(this.value)
    }
    fun notifyObserver() {
        this._users.notifyObserver()
    }

    fun users() : LiveData<MutableList<User>>  = _users
    fun addUser(n : User) {
        val notes = _users.value
        if (notes != null) {
            notes.add(n)
            _users.notifyObserver()
        } else {
            Log.e(TAG, "addUser : user collection is null !!")
        }
    }

    data class User(val id: String, val name: String, val bio: String, val email: String, val role: String) {
        override fun toString(): String = name

        // return an API NoteData from this Note object
        val data : UserProfile
            get() = UserProfile.builder()
                .name(this.name)
                .bio(this.bio)
                .id(this.id)
                .email(this.email)
                .role(this.role)
                .build()

        // static function to create a Note from a NoteData API object
        companion object {
            fun from(userData : UserProfile) : User {
                val result = User(userData.id, userData.name, userData.bio, userData.email, userData.role)
                // some additional code will come here later
                return result
            }
        }

    }

}