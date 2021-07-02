package com.indialone.bottomnavgraphapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.indialone.bottomnavgraphapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var navController: LiveData<NavController>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        if (savedInstanceState == null) {
            setUpBottomNavigation()
        }

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        setUpBottomNavigation()
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.value!!.navigateUp() || super.onSupportNavigateUp()
    }

    private fun setUpBottomNavigation() {
        val graphIds = listOf(
            R.navigation.dishes_nav_graph,
            R.navigation.news_nav_graph
        )

        val controller = mBinding.bottomNav.setupWithNavController(
            graphIds,
            supportFragmentManager,
            R.id.nav_host_fragment,
            intent
        )

        controller.observe(this) {
            setupActionBarWithNavController(it)
        }

        navController = controller

    }
}