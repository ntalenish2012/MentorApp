package com.example.mentorapp

import android.icu.text.Normalizer
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.amplifyframework.datastore.generated.model.QuizResults
import com.amplifyframework.datastore.generated.model.UserProfile
import com.amplifyframework.datastore.generated.model.Matches


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


//match
    private val _matches = MutableLiveData<MutableList<Matches>>(mutableListOf())


    fun notifyObserver1() {
        this._matches.notifyObserver()
    }

    fun matches() : LiveData<MutableList<Matches>>  = _matches
    fun addMatch(n : Matches) {
        val notes = _matches.value
        if (notes != null) {
            notes.add(n)
            _matches.notifyObserver()
        } else {
            Log.e(TAG, "addMatch : match collection is null !!")
        }
    }

    data class Matches(val id: String, val userName: String, val email: String, val type: String, val group: String) {

        // return an API NoteData from this Note object
        val data : Matches
            get() = Matches.builder()
                .id(this.id)
                .userName(this.userName)
                .email(this.email)
                .type(this.type)
                .group(this.group)
                .build()

        // static function to create a Note from a NoteData API object
        companion object {
            fun from(userMatch : Matches) : Matches {
                val result = Matches(userMatch.id, userMatch.userName, userMatch.email, userMatch.type, userMatch.group)
                // some additional code will come here later
                return result
            }

        }

    }

}