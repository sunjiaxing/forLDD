package com.forldd.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.forldd.R
import com.ldd.base.ui.fragment.BaseFragment
import kotlinx.android.synthetic.main.frag_item.*

/**
 * Desc 请描述这个文件
 * Author sunjiaxing
 * Date 2019/2/21 16:57
 */
class ItemFrameFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.frag_item, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tv_tip.text = arguments?.getString("type").orEmpty()
    }
}