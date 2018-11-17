package com.abdullah.dresscode.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.annotation.Nullable


abstract class BaseFragment(@LayoutRes val layoutRes: Int) : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.obtainViewModel();
        this.initNonUi();
    }

    final override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutRes, container, false);
    }

    final override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.initUi(view)
        this.subscribeViewModel()
    }

    final override fun onActivityCreated(@Nullable savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        this.obtainActivityViewModel()
    }

    /**
     * Init or obtain already created fragment's view model in this method.
     */
    protected abstract fun obtainViewModel()

    /**
     * Init stuff which does not require view of fragment. E.g. Adapters, broadcast receivers or any member etc.
     */
    protected abstract fun initNonUi()

    /**
     * Init stuff related to view and UI.
     * @param view holds reference to view of the fragment.
     */
    protected abstract fun initUi(view: View)

    /**
     * Subscribe all observables or LiveData objects from all view models.
     */
    protected abstract fun subscribeViewModel()

    /**
     * Optional method to obtain activity's view model
     */
    protected open fun obtainActivityViewModel() {}
}