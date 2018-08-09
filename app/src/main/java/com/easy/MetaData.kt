package com.easy

import android.app.Activity
import android.content.pm.PackageManager

fun Activity.applicationMetaData(manager: PackageManager, packageName: String, key: String): String {
    var appInfo = manager.getApplicationInfo(packageName, PackageManager.GET_META_DATA)
    return appInfo.metaData.getString(key)
}