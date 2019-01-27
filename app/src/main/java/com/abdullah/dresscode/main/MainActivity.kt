package com.abdullah.dresscode.main
import android.os.Bundle
import com.abdullah.dresscode.R
import com.abdullah.dresscode.base.BaseActivity
import com.abdullah.dresscode.main.ui.main.MainFragment

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }

}
