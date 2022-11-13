package com.example.roomdatabase.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomdatabase.databaseitems.DatabaseFunctions
import com.example.roomdatabase.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = ""
        supportActionBar?.hide()
        val databaseFunctions= DatabaseFunctions(this)
       binding.insertButton.setOnClickListener()
       {
           val title=binding.editTexttitle.text.toString()
           val body=binding.editTextBody.text.toString()
           databaseFunctions.insertData(title,body)
       }
        binding.getButton.setOnClickListener()
        {
            val adapter=databaseFunctions.getData()
            binding.postsRecyclerView.layoutManager = LinearLayoutManager(this)
            binding.postsRecyclerView.adapter = adapter
        }

    }
}
