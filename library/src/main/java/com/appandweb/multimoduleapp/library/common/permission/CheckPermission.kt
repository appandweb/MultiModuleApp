package com.appandweb.multimoduleapp.library.common.permission

interface CheckPermission {
    fun isPermissionGranted(permission: String): Boolean
    fun getPermissionStatus(permission: String): Int
}
