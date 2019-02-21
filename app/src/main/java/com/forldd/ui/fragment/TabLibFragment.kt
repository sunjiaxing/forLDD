package com.forldd.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.forldd.R
import com.ldd.base.ui.fragment.BaseFragment
import kotlinx.android.synthetic.main.frag_tab_lib.*

/**
 * Desc 请描述这个文件
 * Author sunjiaxing
 * Date 2019/2/21 16:57
 */
class TabLibFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.frag_tab_lib, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_tip.text = "LIB"
    }
}