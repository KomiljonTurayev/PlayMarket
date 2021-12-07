package com.example.playmarket

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.playmarket.databinding.ActivityMainBinding
import com.example.playmarket.util.UserSettings
import com.google.android.material.switchmaterial.SwitchMaterial
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var parentView: View? = null
    private var themeSwitch: SwitchMaterial? = null
    private var themeTV: TextView? = null
    private var titleTV: TextView? = null

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        initWidgets()
//        loadSharedPreferences()
//        initSwitchListener()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setSupportActionBar(myToolBar)
        supportActionBar?.hide()
        supportActionBar?.title = "df"
        val title = "Congratulations"
        val body = "Your New Account has been created"
        val goToMyAccount = "Go To My Account"
        val cancel = "Cancel"

        profile_image.setOnClickListener {
                AwesomeDialog.build(this)
                    .title(title)
                    .body(body)

        }

        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_dashboard,
                R.id.navigation_notifications,
            )
        )
//        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
    }


    private fun initWidgets() {
        themeTV = findViewById(R.id.themeTV)
        titleTV = findViewById(R.id.titleTV)
        themeSwitch = findViewById(R.id.themeSwitch)
        parentView = findViewById(R.id.parentView)
    }

    private fun loadSharedPreferences() {
        val sharedPreferences = getSharedPreferences(
            UserSettings.PREFERENCES,
            AppCompatActivity.MODE_PRIVATE
        )
        val theme = sharedPreferences.getString(UserSettings.CUSTOM_THEME, UserSettings.LIGHT_THEME)
        UserSettings.customTheme = theme
//        updateView()
    }

    private fun initSwitchListener() {
        themeSwitch!!.setOnCheckedChangeListener { compoundButton, checked ->
            if (checked) UserSettings.customTheme =
                UserSettings.DARK_THEME else UserSettings.customTheme = UserSettings.LIGHT_THEME
            val editor = getSharedPreferences(
                UserSettings.PREFERENCES,
                AppCompatActivity.MODE_PRIVATE
            ).edit()
            editor.putString(UserSettings.CUSTOM_THEME, UserSettings.customTheme)
            editor.apply()
//            updateView()
        }
    }

    private fun updateView() {
        val black = ContextCompat.getColor(this, R.color.black)
        val white = ContextCompat.getColor(this, R.color.white)
        if (UserSettings.customTheme == UserSettings.DARK_THEME) {
            titleTV!!.setTextColor(white)
            themeTV!!.setTextColor(white)
            themeTV!!.text = "Dark"
            parentView!!.setBackgroundColor(black)
            themeSwitch!!.isChecked = true
        } else {
            titleTV!!.setTextColor(black)
            themeTV!!.setTextColor(black)
            themeTV!!.text = "Light"
            parentView!!.setBackgroundColor(white)
            themeSwitch!!.isChecked = false
        }
    }

    @SuppressLint("WrongConstant")
    private fun initTopDialog() {


    }




}