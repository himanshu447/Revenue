package com.example.knoxpo.revenue.fragments

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.knoxpo.revenue.R
import com.example.knoxpo.revenue.activities.AddPartnerActivity
import com.example.knoxpo.revenue.activities.AddTransactionActivity
import com.example.knoxpo.revenue.model.PartnerModel
import kotlinx.android.synthetic.main.fragment_new_item.*
import com.github.clans.fab.FloatingActionMenu
import java.util.ArrayList


class NewItemFragment : ListFragment<PartnerModel,NewItemFragment.NewPartnerViewHolder>() {


    private val menus = ArrayList<FloatingActionMenu>()
    private val mUiHandler = Handler()
    private val list : MutableList<PartnerModel> = arrayListOf()

    override fun onCreateViewHolder(view: View, viewType: Int): NewPartnerViewHolder {
       return NewPartnerViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewPartnerViewHolder, item: PartnerModel?) {
       holder.bindData(item!!)
    }

    override fun getItemLayoutId(viewType: Int): Int {
        return R.layout.item_transaction
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        for (i in 0..4)
        {
            val model = PartnerModel()
            model.name = "himu"
            model.phoneno=  "7621964990"
            list.add(model)
        }

        addItemsAfterFetch(list)

    }
    inner class NewPartnerViewHolder(item : View) : RecyclerView.ViewHolder(item)
    {
        private val name = item.findViewById<TextView>(R.id.newPartnerNameTV)!!
        private val phoneNo = item.findViewById<TextView>(R.id.newPartnerPhoneTV)!!

        fun bindData(model: PartnerModel)
        {
            name.text = model.name
            phoneNo.text=model.phoneno
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_new_item,container,false)
        addItemsAfterFetch(list)
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        //addNewItemFAB.isEnabled = false

        menu_add_item.setClosedOnTouchOutside(true)

        menu_add_item.hideMenuButton(false)

        menus.add(menu_add_item)

        addNewItemFAB.setOnClickListener {
            val intent = Intent(activity,AddTransactionActivity::class.java)
            startActivity(intent)
        }

        addPartnerFAB.setOnClickListener {
            val intent = Intent(activity,AddPartnerActivity::class.java)
            startActivity(intent)
        }

        var delay = 400
        for (menu in menus) {
            mUiHandler.postDelayed({ menu.showMenuButton(true) }, delay.toLong())
            delay += 150
        }

        menu_add_item.setOnMenuButtonClickListener {

            menu_add_item.toggle(true)
        }
    }
}