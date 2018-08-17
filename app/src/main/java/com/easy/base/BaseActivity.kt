package com.easy.base

import android.app.Activity
import android.app.Application
import com.easy.Logger
import io.objectbox.BoxStore
import org.jetbrains.anko.AnkoLogger

open class BaseActivity : Activity(), Logger,AnkoLogger {

    open fun Activity.boxStore(): BoxStore {
        var baseApplication = application as BaseApplication
        return baseApplication.getBoxStore()
    }
}