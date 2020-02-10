package com.benrostudios.xpenso.ui.xpense

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.benrostudios.xpenso.R

class XpenseFragment : Fragment() {

    companion object {
        fun newInstance() = XpenseFragment()
    }

    private lateinit var viewModel: XpenseViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.xpense_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(XpenseViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
