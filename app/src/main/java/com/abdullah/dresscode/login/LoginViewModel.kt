package com.abdullah.dresscode.login

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.abdullah.dresscode.base.BaseViewModel

class LoginViewModel(application: Application) : BaseViewModel(application) {

    private var loginState: MutableLiveData<State> = MutableLiveData()

    fun getLoginState() : LiveData<State> {
        return loginState
    }

    fun setLoginState(state: State) {
        loginState.value = state
    }

    enum class State {
        LOGIN_HOME, PHONE_ENTRY, CODE_ENTRY, VERIFIED, FAILED
    }
}