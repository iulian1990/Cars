package com.sample.blueline

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.sample.blueline.databinding.ActivityMainBinding
import com.sample.blueline.viewmodels.MessageViewModel

class MainActivity : AppCompatActivity() {

    override fun onDestroy() {
        super.onDestroy()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        setContentView(binding.root)

        val navController = findNavController(R.id.nav_host_fragment)
        binding.bottomNavigation.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.messageDetailFragment) {
                binding.bottomNavigation.visibility = View.GONE
                binding.toolbar.visibility = View.GONE
            } else {
                binding.bottomNavigation.visibility = View.VISIBLE
                binding.toolbar.visibility = View.VISIBLE

                binding.toolbar.title = when (destination.id) {
                    R.id.communicationsFragment -> getString(R.string.communications)
                    R.id.documentsFragment -> getString(R.string.documents)
                    R.id.homeFragment -> getString(R.string.home)
                    R.id.saleFragment -> getString(R.string.sale)
                    R.id.workshopFragment -> getString(R.string.workshop)
                    else -> ""
                }
            }
        }


    }
}