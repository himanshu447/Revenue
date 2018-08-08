package com.example.knoxpo.revenue.fragments

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.knoxpo.revenue.R
import com.example.knoxpo.revenue.model.TransactionModel

class TransactionFragment : ListFragment<TransactionModel, TransactionFragment.MyViewHolder>() {


    private val list : MutableList<TransactionModel> = arrayListOf()

    override fun onBindViewHolder(holder: MyViewHolder, item: TransactionModel?) {
        holder.bindData(item!!)
    }

    override fun onCreateViewHolder(view: View, viewType: Int): MyViewHolder {
        return MyViewHolder(view)
    }

    override fun getItemLayoutId(viewType: Int): Int {
        return R.layout.item_transaction
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        for (i in 0..4)
        {
            val model = TransactionModel()
            model.date1 = "Mar 24, 2018"
            model.amount = i.toString()
            list.add(model)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val v = inflater.inflate(R.layout.fragment_transaction, container, false)
        addItemsAfterFetch(list)
        return v

    }

    inner class MyViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val date2 :TextView = item.findViewById(R.id.transactionDateTV)
        private val amoun2 : TextView = item.findViewById(R.id.tractionAmountTV)

        fun bindData(model: TransactionModel) {
            date2.text = model.date1
            amoun2.text = model.amount

        }

    }
}