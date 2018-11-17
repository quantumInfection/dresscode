package com.abdullah.dresscode.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.abdullah.dresscode.R
import com.abdullah.dresscode.base.BaseActivity
import com.abdullah.dresscode.login.loginhome.LoginHomeFragment
import com.abdullah.dresscode.login.phoneentry.PhoneEntryFragment

class LoginActivity : BaseActivity() {

    lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(R.layout.activity_login)
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
        var fragment: Fragment? = null
        when (state) {
            LoginViewModel.State.LOGIN_HOME -> fragment = LoginHomeFragment.newInstance()
            LoginViewModel.State.PHONE_ENTRY -> fragment = PhoneEntryFragment.newInstance()
            LoginViewModel.State.CODE_ENTRY -> TODO()
            LoginViewModel.State.VERIFIED -> TODO()
            LoginViewModel.State.FAILED -> TODO()
        }
        fragment.let {
            this.supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, it)
                .commitNow()
        }
    }
}
