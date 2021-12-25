package com.dontsu.vectoranimationpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.dontsu.vectoranimationpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initNavController()
    }

    private fun initNavController() = with(binding) {
        val navHostFragment = supportFragmentManager.findFragmentById(mainFragmentContainer.id) as NavHostFragment
        navController = navHostFragment.navController

        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.homeFragment,
            R.id.statsFragment,
            R.id.infoFragment
        ))

        mainBottomView.setupWithNavController(navController)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

}
