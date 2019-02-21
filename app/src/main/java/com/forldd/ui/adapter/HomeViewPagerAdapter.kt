package com.forldd.ui.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Desc 首页Tab适配器
 * Author sunjiaxing
 * Date 2019/2/21 16:51
 */
class HomeViewPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    var fragmentList: List<Fragment>? = null
        set(value) {
            if (!value.isNullOrEmpty()) {
                field = value
                notifyDataSetChanged()
            }
        }

    override fun getItem(pos: Int): Fragment? {
        return fragmentList?.get(pos)
    }

    override fun getCount(): Int {
        return fragmentList?.size ?: 0
    }

}