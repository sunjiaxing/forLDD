package com.ldd.base.common

import com.ldd.base.ui.BaseApplication


/**
 * 将dp转换为与之相等的px
 */
fun dip(dipValue: Float): Int {
    val scale = BaseApplication.application.resources.displayMetrics.density
    return (dipValue * scale + 0.5f).toInt()
}

/**
 * 将sp转换为与之相等的px
 */
fun sp(spValue: Float): Int {
    val fontScale = BaseApplication.application.resources.displayMetrics.scaledDensity
    return (spValue * fontScale + 0.5f).toInt()
}