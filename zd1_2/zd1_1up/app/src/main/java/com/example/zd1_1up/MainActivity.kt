package com.example.zd1_1up

import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.AppBarLayout
import android.widget.Button
import android.support.design.widget.NavigationView
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle

import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.ListView
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupActionBarWithNavController

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken




class MainActivity : AppCompatActivity() {


    private lateinit var navController: NavController
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val host:NavHostFragment=supportFragmentManager
            .findFragmentById(R.id.navFragment)as NavHostFragment? ?:return
        val navController=host.navController
        val sideBar=findViewById<NavigationView>(R.id.nav_view)
        sideBar?.setupWithNavController(navController)
        val drawerLayout = findViewById<android.support.v4.widget.DrawerLayout>(R.id.drawer_layout)
        var appBarConfiguration=AppBarConfiguration(navController.graph,drawerLayout )
        val toolbar=findViewById<Toolbar>(R.id.toolbar2)
        setSupportActionBar(toolbar)
        toolbar.setupWithNavController(navController,appBarConfiguration)


    }
    // включаем верхнее меню (кнопка вверху справа)
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.top_right_menu, menu)
        return true
    }

    // переходим по ссылкам верхнего меню
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return item.onNavDestinationSelected(navController)
                || super.onOptionsItemSelected(item)
    }




}







