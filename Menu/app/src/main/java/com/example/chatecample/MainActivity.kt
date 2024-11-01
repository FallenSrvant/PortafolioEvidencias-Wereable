package com.example.chatecample

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.chatecample.databinding.ActivityMainBinding
import fragments.FragmentChats
import fragments.FragmentProfile
import fragments.FragmentUsers

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //viewFragmentProfile()
        binding = ActivityMainBinding.inflate(layoutInflater)

        enableEdgeToEdge()

        setContentView(binding.root)

        firebaseAuth = Fi

        binding.bottomNV.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.item_profile -> {
                    //Visualizar el fragmento profile
                    viewFragmentProfile()
                    true
                }
                R.id.item_users -> {
                    //Visualizar el fragmento users
                    viewFragmentUsers()
                    true
                }
                R.id.item_chats -> {
                    //Visualizar el fragmento chats
                    viewFragmentChats()
                    true
                }
                else -> {
                    false
                }
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


    }

    private fun viewFragmentProfile(){
        binding.tvTitle.text = "Profile"
        val fragment = FragmentProfile()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(binding.fragmentFL.id, fragment)
        fragmentTransaction.commit()
    }
    private fun viewFragmentUsers(){
        binding.tvTitle.text = "Users"
        val fragment = FragmentUsers()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(binding.fragmentFL.id, fragment)
        fragmentTransaction.commit()
    }
    private fun viewFragmentChats(){
        binding.tvTitle.text = "Chats"
        val fragment = FragmentChats()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(binding.fragmentFL.id, fragment)
        fragmentTransaction.commit()
    }

}