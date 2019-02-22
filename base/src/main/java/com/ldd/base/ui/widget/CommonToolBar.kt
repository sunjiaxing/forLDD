package com.ldd.base.ui.widget

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.util.StateSet
import android.view.Gravity
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.ldd.base.R
import com.ldd.base.common.dip

/**
 * Desc 通用ToolBar (适用左中右)
 * Author sunjiaxing
 * Date 2019/1/16 14:57
 */
class CommonToolBar : RelativeLayout {

    var onLeftClick: (() -> Unit)? = null
    var onRightClick: (() -> Unit)? = null

    private var leftDrawable: Drawable? = null
    private var rightDrawable: Drawable? = null
    private var title: String? = null
    private var titleColor = 0
    private var titleSize = 0f
    private var imgLeft: ImageView? = null
    private var imgRight: ImageView? = null
    private var txtTitle: TextView? = null

    private val mHandleWidth = dip(48f)
    private val mHandleHeight = dip(48f)
    private var mPadding = dip(12f)

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        loadDefaultSetting(attrs)
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        loadDefaultSetting(attrs)
        init()
    }

    fun setTitle(title: String) {
        txtTitle?.text = title
    }

    private fun loadDefaultSetting(attrs: AttributeSet) {
        val ta = context.obtainStyledAttributes(attrs, R.styleable.CommonToolBar)
        leftDrawable = ta.getDrawable(R.styleable.CommonToolBar_left_drawable)
        rightDrawable = ta.getDrawable(R.styleable.CommonToolBar_right_drawable)
        title = ta.getString(R.styleable.CommonToolBar_title)
        titleColor = ta.getColor(R.styleable.CommonToolBar_android_textColor, Color.parseColor("#282828"))
        titleSize = ta.getDimension(R.styleable.CommonToolBar_android_textSize, 18f)
//        mPadding = ta.getDimension(R.styleable.CommonToolBar_drawable_padding, 12f).toInt()
        ta.recycle()
    }

    private fun init() {
        // 左侧按钮
        if (leftDrawable != null) {
            val leftLayoutParams = RelativeLayout.LayoutParams(mHandleWidth, mHandleHeight)

            imgLeft = ImageView(context)
            val leftStateListDrawable = CustomStateListDrawable { pressed, enabled ->
                imgLeft?.alpha = if (pressed || !enabled) 0.4f else 1.0f
            }
            leftStateListDrawable.addState(StateSet.WILD_CARD, leftDrawable)
            imgLeft?.setImageDrawable(leftStateListDrawable)
            imgLeft?.setPadding(mPadding, mPadding, mPadding, mPadding)
            imgLeft?.setOnClickListener { onLeftClick?.invoke() }

            addView(imgLeft, leftLayoutParams)
        }

        // 右侧按钮
        if (rightDrawable != null) {
            val rightLayoutParams = RelativeLayout.LayoutParams(mHandleWidth, mHandleHeight)
            rightLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE)

            imgRight = ImageView(context)
            val rightStateListDrawable = CustomStateListDrawable { pressed, enabled ->
                imgRight?.alpha = if (pressed || !enabled) 0.4f else 1.0f
            }
            rightStateListDrawable.addState(StateSet.WILD_CARD, rightDrawable)
            imgRight?.setImageDrawable(rightStateListDrawable)
            imgRight?.setPadding(mPadding, mPadding, mPadding, mPadding)
            imgRight?.setOnClickListener { onRightClick?.invoke() }

            addView(imgRight, rightLayoutParams)
        }

        // 中间title
        if (!title.isNullOrBlank()) {
            val centerLayoutParams = RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, mHandleHeight)
            centerLayoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE)

            txtTitle = TextView(context)
            txtTitle?.includeFontPadding = true
            txtTitle?.text = title
            txtTitle?.setTextColor(titleColor)
            txtTitle?.textSize = titleSize
            txtTitle?.gravity = Gravity.CENTER

            addView(txtTitle, centerLayoutParams)
        }
    }

    fun setDrawablePadding(padding: Int) {
        this.mPadding = padding

        if (leftDrawable != null) {
            imgLeft?.setPadding(mPadding, mPadding, mPadding, mPadding)
        }

        if (rightDrawable != null) {
            imgRight?.setPadding(mPadding, mPadding, mPadding, mPadding)
        }
    }

}