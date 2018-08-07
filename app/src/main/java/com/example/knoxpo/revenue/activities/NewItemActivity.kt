package com.example.knoxpo.revenue.activities

import android.support.v4.app.Fragment
import com.example.knoxpo.revenue.fragments.NewItemFragment

class NewItemActivity : SingleFragmentActivity(){

    override fun getFragment(): Fragment {
        return NewItemFragment()
    }

}
