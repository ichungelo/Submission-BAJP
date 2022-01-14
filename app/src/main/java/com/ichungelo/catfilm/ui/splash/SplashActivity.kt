package com.ichungelo.catfilm.ui.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import com.ichungelo.catfilm.databinding.ActivitySplashBinding
import com.ichungelo.catfilm.ui.main.MainActivity

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val splashStatusBarColor = Color.rgb(211, 47, 47)
        val splashNavigationBarColor = Color.rgb(211, 47, 47)

        with(window) {
            statusBarColor = splashStatusBarColor
            navigationBarColor = splashNavigationBarColor
        }
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN


        sleepSplash()
    }

    private fun sleepSplash() {
        val background = object : Thread() {
            override fun run() {
                try {
                    sleep(SLEEP_DURATION)
                    val intent = Intent(baseContext, MainActivity::class.java)
                    startActivity(intent)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
        background.start()
    }

    companion object {
        const val SLEEP_DURATION = 3000L
    }
}