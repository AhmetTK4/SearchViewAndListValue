package com.ahmet.challenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.SearchView
import com.ahmet.challenge.databinding.ActivityMainBinding

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
val user = arrayOf("ahmet","mehmet","selim","mustafa","ayşe","aslı","mert","eren","gizem","can","selen")

        val userAdapter : ArrayAdapter<String> = ArrayAdapter(
            this,android.R.layout.simple_list_item_1,
            user
        )

        binding.userList.adapter = userAdapter

        binding.searchVie.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                binding.searchVie.clearFocus()
                if (user.contains(query)){

                    userAdapter.filter.filter(query)
                }
                return false
            }


            override fun onQueryTextChange(newText: String?): Boolean {
                userAdapter.filter.filter(newText)
                return false
            }


        })
    }
}