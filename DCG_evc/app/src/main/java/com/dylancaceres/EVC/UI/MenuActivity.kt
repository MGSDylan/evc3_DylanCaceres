package com.dylancaceres.EVC.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.dylancaceres.EVC.R
import com.dylancaceres.EVC.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setTitle("Star Wars")

        val fragmentView = supportFragmentManager.findFragmentById(R.id.fvc_navigation)as NavHostFragment
        val navController=fragmentView.navController
        binding.bnvMain.setupWithNavController(navController)


    }
}