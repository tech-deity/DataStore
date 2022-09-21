package com.techdeity.notionapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.techdeity.notionapp.databinding.ActivityMainBinding
import com.techdeity.notionapp.viewmodel.ActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding :ActivityMainBinding
    private val activityViewModel:ActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.lifecycleOwner = this







//        val name = "Vishal"
//
//        binding.textView1.text = name
//

    }


    override fun onDestroy() {
        super.onDestroy()

    }

}

