package com.abdullah.dresscode.main.ui.main

import androidx.lifecycle.ViewModelProviders
import android.view.View
import com.abdullah.dresscode.R
import com.abdullah.dresscode.base.BaseFragment

class MainFragment : BaseFragment(R.layout.main_fragment) {
    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun obtainViewModel() {
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    override fun initNonUi() {
    }

    override fun initUi(view: View) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun subscribeViewModel() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
