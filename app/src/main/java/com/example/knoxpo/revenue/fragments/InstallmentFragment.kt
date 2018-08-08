package com.example.knoxpo.revenue.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.knoxpo.revenue.R
import com.example.knoxpo.revenue.model.InstallmentModel

private const val INSTALLMENT_RED = 1
private const val INSTALLMENT_GREEN = 0
private const val INSTALLMENT_YELLOW = 2

class InstallmentFragment : ListFragment<Any, RecyclerView.ViewHolder>() {


    val list :MutableList<InstallmentModel> = arrayListOf()

    override fun onCreateViewHolder(view: View, viewType: Int) = when (viewType) {
        INSTALLMENT_GREEN -> InstalmentGreenVH(view)
        INSTALLMENT_RED -> InstalmentRedVH(view)
        INSTALLMENT_YELLOW -> InstalmentYellowVH(view)
        else -> throw RuntimeException("Invalid layout type: $viewType")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: Any?) {

        if(holder is InstalmentGreenVH)
            holder.bind(item as InstallmentModel)
        else if (holder is InstalmentRedVH)
            holder.bind(item as InstallmentModel)
        else if (holder is InstalmentYellowVH)
            holder.bind(item as InstallmentModel)
    }


    override fun getItemType(item: Any): Int {

        return if (item is InstallmentModel) {
            INSTALLMENT_RED
        } else {
            super.getItemType(item)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        for (i in 0..4)
        {
            val model= InstallmentModel()
            model.amount = i.toString()
            model.date1= "24.2018"
            model.day= "06"
            model.dayWeek="friday"
            list.add(model)
        }

        addItemsAfterFetch(list)

    }

    override fun getFragmentLayoutId(): Int {
        return R.layout.item_installment_green
    }

    override fun getItemLayoutId(viewType: Int) = when(viewType){
        INSTALLMENT_GREEN -> R.layout.item_installment_green
        INSTALLMENT_RED-> R.layout.item_installment_red
        INSTALLMENT_YELLOW->R.layout.item_installment_yellow
        else -> throw RuntimeException("invlid type")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    }


    inner class InstalmentRedVH(item: View) : RecyclerView.ViewHolder(item) {

        val day = item.findViewById<TextView>(R.id.installRedDayTV)
        val date1 = item.findViewById<TextView>(R.id.installRedDateTV)
        val dayOfWeek = item.findViewById<TextView>(R.id.installRedWeekDayTV)
        val amount = item.findViewById<TextView>(R.id.installRedAmountTV)

        fun bind(model: InstallmentModel) {

            day.text = model.day.toString()
            date1.text = model.date1
            dayOfWeek.text = model.dayWeek
            amount.text = model.amount

        }
    }


    inner class InstalmentYellowVH(item: View) : RecyclerView.ViewHolder(item) {

        val day = item.findViewById<TextView>(R.id.installYellowDayTV)
        val date1 = item.findViewById<TextView>(R.id.installYellowDateTV)
        val dayOfWeek = item.findViewById<TextView>(R.id.installYellowWeekDayTV)
        val amount = item.findViewById<TextView>(R.id.installYelloAmountTV)

        fun bind(model: InstallmentModel) {

            day.text = model.day.toString()
            date1.text = model.date1
            dayOfWeek.text = model.dayWeek
            amount.text = model.amount

        }

    }

    inner class InstalmentGreenVH(item: View) : RecyclerView.ViewHolder(item) {
        val day = item.findViewById<TextView>(R.id.installGreenDayTV)
        val date1 = item.findViewById<TextView>(R.id.installGreenDateTV)
        val dayOfWeek = item.findViewById<TextView>(R.id.installGreenWeekDayTV)
        val amount = item.findViewById<TextView>(R.id.installGreenAmountTV)

        fun bind(model: InstallmentModel) {
            day.text = model.day.toString()
            date1.text = model.date1
            dayOfWeek.text = model.dayWeek
            amount.text = model.amount

        }
    }

}