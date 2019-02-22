package com.forldd.ui.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import com.forldd.ui.adapter.ViewPagerAdapter
import com.forldd.ui.fragment.ItemFrameFragment
import com.ldd.base.ui.activity.BaseActivity
import kotlinx.android.synthetic.main.act_tab_layout.*


/**
 * Desc 请描述这个文件
 * Author sunjiaxing
 * Date 2019/2/22 11:39
 */
class TabLayoutActivity : BaseActivity() {

    private val tabTitles = arrayOf("全部", "视频", "声音", "图片", "段子", "广告", "剧情")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.forldd.R.layout.act_tab_layout)
        tool_bar.onLeftClick = {
            finish()
        }

        val adapter = ViewPagerAdapter(supportFragmentManager)
        val fragmentList = ArrayList<Fragment>()

        tabTitles.forEach {
            val fragment = ItemFrameFragment()
            val bundle = Bundle()
            bundle.putString("type", it)
            fragment.arguments = bundle
            fragmentList.add(fragment)
        }

        vp_container.adapter = adapter
        adapter.fragmentList = fragmentList
        adapter.titleList = tabTitles.toList()

        tab_layout.setupWithViewPager(vp_container)
    }
}