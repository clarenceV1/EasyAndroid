package com.easy

import android.util.Log

interface Logger {
    fun Logger.verbose(message: Any?, thr: Throwable? = null) {
        val tag = this.javaClass.simpleName
        if (tag.length > 23)
            tag.substring(0, 23)
        Log.v(tag, message?.toString())
    }

    fun Logger.info(message: Any?, thr: Throwable? = null) {
        val tag = this.javaClass.simpleName
        if (tag.length > 23)
            tag.substring(0, 23)
        Log.i(tag, message?.toString())
    }

    fun Logger.warn(message: Any?, thr: Throwable? = null) {
        val tag = this.javaClass.simpleName
        if (tag.length > 23)
            tag.substring(0, 23)
        Log.w(tag, message?.toString())
    }

    fun Logger.debug(message: Any?, thr: Throwable? = null) {
        val tag = this.javaClass.simpleName
        if (tag.length > 23)
            tag.substring(0, 23)
        Log.d(tag, message?.toString())
    }

    fun Logger.error(message: Any?, thr: Throwable? = null) {
        val tag = this.javaClass.simpleName
        if (tag.length > 23)
            tag.substring(0, 23)
        Log.e(tag, message?.toString())
    }
}