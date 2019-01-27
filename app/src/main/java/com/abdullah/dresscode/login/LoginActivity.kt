package com.abdullah.dresscode.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.abdullah.dresscode.R
import com.abdullah.dresscode.base.BaseActivity
import com.abdullah.dresscode.login.loginhome.LoginHomeFragment
import com.firebase.ui.auth.AuthUI
import java.util.*

class LoginActivity : BaseActivity() {

    private lateinit var viewModel: LoginViewModel
    private val RC_SIGN_IN = 123

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(com.abdullah.dresscode.R.layout.activity_login)
        this.initViewModel()
        if (savedInstanceState == null) {
            viewModel.setLoginState(LoginViewModel.State.LOGIN_HOME)
        }
        this.subscribeViewModel()
    }

    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
    }

    private fun subscribeViewModel() {
        viewModel.getLoginState().observe(this, Observer { state -> this.onLoginStateUpdated(state) })
    }

    private fun onLoginStateUpdated(state: LoginViewModel.State) {
        when (state) {
            LoginViewModel.State.LOGIN_HOME -> {
                this.supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, LoginHomeFragment.newInstance())
                    .commitNow()
            }
            LoginViewModel.State.FIREBASE_UI -> this.openFirebaseUi()
        }
    }

    private fun openFirebaseUi() {
        this.startActivityForResult(
            AuthUI.getInstance().createSignInIntentBuilder()
                .setAvailableProviders(Collections.singletonList((AuthUI.IdpConfig.PhoneBuilder().build())))
                .build(),
            RC_SIGN_IN
        );
    }
}
