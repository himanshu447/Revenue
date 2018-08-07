package com.example.knoxpo.revenue.activities

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.example.knoxpo.revenue.R

abstract class SingleFragmentActivity : AppCompatActivity() {

    abstract fun getFragment(): Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_fragment_activty)


        val fragment = supportFragmentManager.findFragmentById(R.id.fragment_container)

        if (fragment == null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container, getFragment())
                    .commit()
        }
    }
}

