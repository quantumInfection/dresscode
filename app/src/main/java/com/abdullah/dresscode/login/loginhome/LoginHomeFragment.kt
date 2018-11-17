package com.abdullah.dresscode.login.loginhome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.abdullah.dresscode.R
import com.abdullah.dresscode.base.BaseFragment
import com.abdullah.dresscode.login.LoginViewModel
import kotlinx.android.synthetic.main.fragment_login_home.view.*

class LoginHomeFragment : BaseFragment(R.layout.fragment_login_home) {

    companion object {
        fun newInstance() : LoginHomeFragment {
            return LoginHomeFragment()
        }
    }

    lateinit var loginViewModel: LoginViewModel

    override fun obtainViewModel() {}

    override fun initNonUi() {}

    override fun initUi(view: View) {
        view.loginButton.setOnClickListener {
            loginViewModel.setLoginState(LoginViewModel.State.PHONE_ENTRY)
        }
    }

    override fun subscribeViewModel() {}

    override fun obtainActivityViewModel() {
        loginViewModel = this.activity?.let { ViewModelProviders.of(it).get(LoginViewModel::class.java) }!!
    }
}