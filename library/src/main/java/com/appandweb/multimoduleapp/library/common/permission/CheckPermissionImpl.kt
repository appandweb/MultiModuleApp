package com.appandweb.multimoduleapp.library.common.permission

import android.content.Context
import android.content.pm.PackageManager
import android.support.v4.content.ContextCompat
import java.lang.ref.WeakReference

class CheckPermissionImpl(private val contextRef: WeakReference<Context>?) : CheckPermission {
    override fun isPermissionGranted(permission: String): Boolean {
        contextRef?.get()?.let {
            return ContextCompat.checkSelfPermission(it, permission) == PackageManager.PERMISSION_GRANTED
        }

        return false
    }

    override fun getPermissionStatus(permission: String): Int {
        contextRef?.get()?.let {
            return ContextCompat.checkSelfPermission(it, permission)
        }

        return PackageManager.PERMISSION_DENIED
    }
}