package com.ldd.base.ui.widget

import android.graphics.drawable.StateListDrawable

class CustomStateListDrawable(private val stateChangeListener: (press: Boolean, enable: Boolean) -> Unit) : StateListDrawable() {

    @Override
    override fun isStateful(): Boolean = true

    @Override
    override fun setState(stateSet: IntArray?): Boolean {

        if (stateSet == null) return false

        super.setState(stateSet)

        var pressed = false
        var enabled = false

        stateSet.forEach {
            pressed = if (it == android.R.attr.state_pressed) true else pressed
            enabled = if (it == android.R.attr.state_enabled) true else enabled
        }

        stateChangeListener.invoke(pressed, enabled)

        return true
    }
}