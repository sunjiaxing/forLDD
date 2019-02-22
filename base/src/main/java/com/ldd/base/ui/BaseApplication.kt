package com.ldd.base.ui

import android.app.Application
import android.content.Context

/**
 * Desc 请描述这个文件
 * Author sunjiaxing
 * Date 2019/2/22 11:47
 */
open class BaseApplication : Application() {

    override fun attachBaseContext(context: Context) {
        super.attachBaseContext(context)
        application = this
    }

    companion object {

        lateinit var application: BaseApplication
            private set

    }
}