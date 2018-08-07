package com.example.knoxpo.revenue.activities

import android.support.v4.app.Fragment
import com.example.knoxpo.revenue.fragments.TransactionFragment

class TransactionActivity : SingleFragmentActivity(){

    override fun getFragment(): Fragment {
        return TransactionFragment()
    }
}