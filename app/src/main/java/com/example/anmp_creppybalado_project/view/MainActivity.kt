package com.example.anmp_creppybalado_project.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.anmp_creppybalado_project.R
import com.example.anmp_creppybalado_project.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        navController = (supportFragmentManager.findFragmentById(R.id.hostFragment)
                as NavHostFragment).navController
        NavigationUI.setupActionBarWithNavController(this, navController, binding.drawerLayout)
        binding.bottomNav.setupWithNavController(navController)
        NavigationUI.setupWithNavController(binding.navView, navController)

        val isLoggedIn = checkIfUserIsLoggedIn()
        val startDestination = if (isLoggedIn) R.id.homeFragment else R.id.loginFragment

        val navGraph = navController.navInflater.inflate(R.navigation.game_navigation)
        navGraph.setStartDestination(startDestination)
        navController.graph = navGraph

    }
    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, binding.drawerLayout)
                || super.onSupportNavigateUp()
    }

    private fun checkIfUserIsLoggedIn(): Boolean {
        val sharedPreferences = getSharedPreferences("user_session", Context.MODE_PRIVATE)
        return sharedPreferences.getBoolean("is_logged_in", false)
    }

}
