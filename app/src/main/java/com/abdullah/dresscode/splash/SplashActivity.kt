package com.abdullah.dresscode.splash

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.abdullah.dresscode.base.BaseActivity
import com.abdullah.dresscode.login.LoginActivity
import com.abdullah.dresscode.main.MainActivity
import com.google.firebase.auth.FirebaseAuth

class SplashActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.checkLoginState()
    }

    private fun checkLoginState() {
        var intent: Intent? = null
        if (FirebaseAuth.getInstance().currentUser == null) {
            intent = Intent(this, LoginActivity::class.java)

        } else {
            intent = Intent(this, MainActivity::class.java)
        }
        this.startActivity(intent)
    }
}