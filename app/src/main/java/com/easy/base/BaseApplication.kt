package com.easy.base

import android.app.Application
import com.easy.data.MyObjectBox
import io.objectbox.BoxStore


open class BaseApplication : Application() {
    private lateinit var mBoxStore: BoxStore

    override fun onCreate() {
        super.onCreate()
        initSql()
    }

    private fun initSql() {
        mBoxStore = MyObjectBox.builder().androidContext(this).build()
    }

    fun getBoxStore() = mBoxStore
}