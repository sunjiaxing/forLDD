package com.forldd.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.forldd.R
import com.forldd.ui.activity.TabLayoutActivity
import com.ldd.base.ui.fragment.BaseFragment
import kotlinx.android.synthetic.main.frag_tab_ui.*

/**
 * Desc 请描述这个文件
 * Author sunjiaxing
 * Date 2019/2/21 16:57
 */
class TabUIFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.frag_tab_ui, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_to_tab_layout.setOnClickListener {
            startActivity(Intent(context, TabLayoutActivity::class.java))
        }
    }
}