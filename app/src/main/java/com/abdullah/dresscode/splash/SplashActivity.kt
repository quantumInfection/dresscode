package com.abdullah.dresscode.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.abdullah.dresscode.base.BaseActivity
import com.abdullah.dresscode.login.LoginActivity

class SplashActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Handler().postDelayed({checkLoginState()}, 3000)
    }

    private fun checkLoginState() {
        val intent = Intent(this, LoginActivity::class.java)
        this.startActivity(intent)
    }
}