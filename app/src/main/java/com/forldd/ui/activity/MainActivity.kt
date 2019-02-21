package com.forldd.ui.activity

import android.os.Bundle
import android.support.v4.view.ViewPager
import com.forldd.R
import com.forldd.ui.adapter.HomeViewPagerAdapter
import com.forldd.ui.fragment.TabFrameFragment
import com.forldd.ui.fragment.TabLibFragment
import com.forldd.ui.fragment.TabMineFragment
import com.forldd.ui.fragment.TabUIFragment
import com.ldd.base.ui.activity.BaseActivity
import kotlinx.android.synthetic.main.act_main.*

class MainActivity : BaseActivity() {

    private val tabUIFragment by lazy { TabUIFragment() }

    private val tabLibFragment by lazy { TabLibFragment() }

    private val tabFrameFragment by lazy { TabFrameFragment() }

    private val tabMineFragment by lazy { TabMineFragment() }

    private val fragmentList by lazy { arrayListOf(tabUIFragment, tabLibFragment, tabFrameFragment, tabMineFragment) }

    private val homeViewAdapter by lazy { HomeViewPagerAdapter(supportFragmentManager) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_main)

        initView()
    }

    private fun initView() {
        tv_tab_ui.isSelected = true
        tv_tab_ui.setOnClickListener { setTabSelect(0) }
        tv_tab_lib.setOnClickListener { setTabSelect(1) }
        tv_tab_frame.setOnClickListener { setTabSelect(2) }
        tv_tab_mine.setOnClickListener { setTabSelect(3) }

        vp_container.offscreenPageLimit = 4
        vp_container.adapter = homeViewAdapter
        vp_container.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(position: Int) {

            }

            override fun onPageScrolled(position: Int, p1: Float, p2: Int) {

            }

            override fun onPageSelected(position: Int) {
                setTabSelect(position)
            }

        })
        homeViewAdapter.fragmentList = fragmentList
    }

    private fun setTabSelect(position: Int) {
        tv_tab_ui.isSelected = position == 0
        tv_tab_lib.isSelected = position == 1
        tv_tab_frame.isSelected = position == 2
        tv_tab_mine.isSelected = position == 3

        if (vp_container.currentItem != position) {
            vp_container.setCurrentItem(position,false)
        }
    }
}
