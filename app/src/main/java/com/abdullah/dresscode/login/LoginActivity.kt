package com.abdullah.dresscode.login

import android.os.Bundle
import com.abdullah.dresscode.R
import com.abdullah.dresscode.base.BaseActivity

class LoginActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(R.layout.activity_login)
        if (savedInstanceState == null) {
            this.supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, LoginFragment.newInstance())
                .commitNow()
        }
    }
}
