package com.example.knoxpo.revenue.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.knoxpo.revenue.R

class InstallmentFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val v = inflater.inflate(R.layout.item_installment_green,container,false)
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }
}