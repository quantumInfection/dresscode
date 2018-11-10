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

class LoginHomeFragment : BaseFragment() {
    companion object {
        fun newInstance() : LoginHomeFragment {
            return LoginHomeFragment()
        }
    }

    lateinit var loginViewModel: LoginViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_login_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.initUi(view)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        loginViewModel = this.activity?.let { ViewModelProviders.of(it).get(LoginViewModel::class.java) }!!
    }

    private fun initUi(view: View) {
        view.loginButton.setOnClickListener {
            loginViewModel.setLoginState(LoginViewModel.State.PHONE_ENTRY)
        }
    }
}