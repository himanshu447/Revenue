package com.example.knoxpo.revenue.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.knoxpo.revenue.R
import com.github.clans.fab.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_new_item.*
import com.github.clans.fab.FloatingActionMenu


class NewItemFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_new_item,container,false)
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        var menuRed = view.findViewById(R.id.menu_red) as FloatingActionMenu
        val fab1 = view.findViewById(R.id.fab1) as FloatingActionButton
        val fab2 = view.findViewById(R.id.fab2) as FloatingActionButton
        val fab3 = view.findViewById(R.id.fab3) as FloatingActionButton

        fab1.isEnabled = false
        menuRed.setClosedOnTouchOutside(true)

        menuRed.hideMenuButton(false)
    }

}