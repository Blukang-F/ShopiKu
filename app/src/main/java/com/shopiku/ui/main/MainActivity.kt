package com.shopiku.ui.main

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.shopiku.R
import com.shopiku.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        binding.bottomNav.setupWithNavController(navController)

        // Show BottomNav only on top-level destinations
        navController.addOnDestinationChangedListener { _, destination, _ ->
            val topLevelIds = setOf(
                R.id.homeFragment,
                R.id.categoryFragment,
                R.id.favoriteFragment,
                R.id.ordersFragment,
                R.id.profileFragment
            )
            binding.bottomNav.visibility =
                if (destination.id in topLevelIds) View.VISIBLE else View.GONE
        }
    }

    override fun onSupportNavigateUp(): Boolean =
        navController.navigateUp() || super.onSupportNavigateUp()

    fun getCartBadgeCount(): Int = 0 // Updated by CartViewModel via shared state
}
