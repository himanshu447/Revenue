package com.example.knoxpo.revenue.activities

import android.support.v4.app.Fragment
import com.example.knoxpo.revenue.fragments.InstallmentFragment

class InstallmentsActivitty : SingleFragmentActivity(){

    override fun getFragment(): Fragment {

        return InstallmentFragment()
    }
}