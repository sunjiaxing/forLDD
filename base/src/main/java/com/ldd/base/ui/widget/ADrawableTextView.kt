package com.ldd.base.ui.widget

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.v7.widget.AppCompatTextView
import android.util.AttributeSet
import com.ldd.base.R

/**
 * Desc 自定义可修改drawable大小的TextView 【AnyDrawableTextView】
 * Author sunjiaxing
 * Date 2019/2/21 10:55
 */
class ADrawableTextView : AppCompatTextView {

    private var drawableLeftWidth = 0
    private var drawableLeftHeight = 0
    private var drawableTopWidth = 0
    private var drawableTopHeight = 0
    private var drawableRightWidth = 0
    private var drawableRightHeight = 0
    private var drawableBottomWidth = 0
    private var drawableBottomHeight = 0

    private var drawableLeft: Drawable? = null
    private var drawableTop: Drawable? = null
    private var drawableRight: Drawable? = null
    private var drawableBottom: Drawable? = null

    constructor(context: Context?) : super(context)

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        initAttr(attrs)
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initAttr(attrs)
    }

    private fun initAttr(attrs: AttributeSet?) {
        val ta = context.obtainStyledAttributes(attrs, R.styleable.ADrawableTextView)
        drawableLeftWidth = ta.getDimension(R.styleable.ADrawableTextView_drawable_left_width, 0f).toInt()
        drawableLeftHeight = ta.getDimension(R.styleable.ADrawableTextView_drawable_left_height, 0f).toInt()
        drawableTopWidth = ta.getDimension(R.styleable.ADrawableTextView_drawable_top_width, 0f).toInt()
        drawableTopHeight = ta.getDimension(R.styleable.ADrawableTextView_drawable_top_height, 0f).toInt()
        drawableRightWidth = ta.getDimension(R.styleable.ADrawableTextView_drawable_right_width, 0f).toInt()
        drawableRightHeight = ta.getDimension(R.styleable.ADrawableTextView_drawable_right_height, 0f).toInt()
        drawableBottomWidth = ta.getDimension(R.styleable.ADrawableTextView_drawable_bottom_width, 0f).toInt()
        drawableBottomHeight = ta.getDimension(R.styleable.ADrawableTextView_drawable_bottom_height, 0f).toInt()
        ta.recycle()

        setCompoundDrawablesWithIntrinsicBounds(drawableLeft, drawableTop, drawableRight, drawableBottom)
    }

    override fun setCompoundDrawablesWithIntrinsicBounds(
        left: Drawable?,
        top: Drawable?,
        right: Drawable?,
        bottom: Drawable?
    ) {
        drawableLeft = left
        drawableTop = top
        drawableRight = right
        drawableBottom = bottom

        left?.setBounds(
            0,
            0,
            checkValid(drawableLeftWidth, left.intrinsicWidth),
            checkValid(drawableLeftHeight, left.intrinsicHeight)
        )

        right?.setBounds(
            0,
            0,
            checkValid(drawableRightWidth, right.intrinsicWidth),
            checkValid(drawableRightHeight, right.intrinsicHeight)
        )

        top?.setBounds(
            0,
            0,
            checkValid(drawableTopWidth, top.intrinsicWidth),
            checkValid(drawableTopHeight, top.intrinsicHeight)
        )

        bottom?.setBounds(
            0,
            0,
            checkValid(drawableBottomWidth, bottom.intrinsicWidth),
            checkValid(drawableBottomHeight, bottom.intrinsicHeight)
        )

        setCompoundDrawables(left, top, right, bottom)
    }

    private fun checkValid(value: Int, default: Int = 0): Int {

        return if (value == 0) default else value
    }
}