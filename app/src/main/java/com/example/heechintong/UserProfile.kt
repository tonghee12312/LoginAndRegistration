package com.example.heechintong

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.widget.Toast
import com.example.heechintong.databinding.ActivityUserProfileBinding
import com.google.firebase.auth.ActionCodeUrl
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.net.URL
import java.util.jar.Attributes

class UserProfile : AppCompatActivity() {

    private lateinit var binding :ActivityUserProfileBinding
    private lateinit var auth:FirebaseAuth
    private lateinit var databaseReference: DatabaseReference
    private lateinit var storageReference: StorageReference
    private lateinit var imageUri: Uri

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()
        val uid = auth.currentUser?.uid
        databaseReference = FirebaseDatabase.getInstance().getReference("Users")
        binding.buttonSubmitUserProfile.setOnClickListener {
            val name = binding.editTextUserProfileName.toString()
            val age = binding.editTextUserProfileAge.toString()
            val gender = binding.editTextUserProfileGender.toString()
            val bio = binding.editTextUserProfileBio.toString()

            val user = User(name, age, gender, bio)
            if(uid !=null){
                databaseReference.child(uid).setValue(user).addOnCompleteListener(){

                    if(it.isSuccessful){
                      //  uploadProfilePic()
                    }else{
                        Toast.makeText(this@UserProfile, "failed to update profile!!!", Toast.LENGTH_SHORT).show()  }
                    }
                }
            }
        }
   // private fun uploadProfilePic(){
     //   imageUri = Uri.parse("android.resource://$packageName/${R.drawable.profile}")
     //   storageReference = FirebaseStorage.getInstance().getReference(("Users/"+auth.currentUser?.uid))
     //   storageReference.profile(imageUri).addOnSuccessListener{

        }



