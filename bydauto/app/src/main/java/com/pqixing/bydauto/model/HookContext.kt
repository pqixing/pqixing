//package com.pqixing.bydauto.model
//
//import android.content.Context
//import android.content.ContextWrapper
//import android.content.pm.PackageManager
//import android.net.Uri
//import com.pqixing.bydauto.utils.hook
//import com.pqixing.bydauto.utils.log
//
//open class HookContext(base: Context, val pkg: String?) : ContextWrapper(base) {
//
//    override fun getApplicationContext(): Context {
//        return super.getApplicationContext().hook()
//    }
//
//    override fun getBaseContext(): Context {
//        return super.getBaseContext().hook()
//    }
//
//    override fun checkCallingOrSelfPermission(permission: String): Int {
//        return PackageManager.PERMISSION_GRANTED
//    }
//
//    override fun checkCallingOrSelfUriPermission(uri: Uri?, modeFlags: Int): Int {
//        return PackageManager.PERMISSION_GRANTED
//    }
//
//    override fun checkCallingOrSelfUriPermissions(uris: MutableList<Uri>, modeFlags: Int): IntArray {
//        return uris.map { PackageManager.PERMISSION_GRANTED }.toIntArray()
//    }
//
//    override fun checkCallingPermission(permission: String): Int {
//        return PackageManager.PERMISSION_GRANTED
//    }
//
//    override fun checkCallingUriPermission(uri: Uri?, modeFlags: Int): Int {
//        return PackageManager.PERMISSION_GRANTED
//    }
//
//    override fun checkCallingUriPermissions(uris: MutableList<Uri>, modeFlags: Int): IntArray {
//        return uris.map { PackageManager.PERMISSION_GRANTED }.toIntArray()
//    }
//
//    override fun checkPermission(permission: String, pid: Int, uid: Int): Int {
//        return PackageManager.PERMISSION_GRANTED
//    }
//
//    override fun checkSelfPermission(permission: String): Int {
//        return PackageManager.PERMISSION_GRANTED
//    }
//
//    override fun checkUriPermission(uri: Uri?, pid: Int, uid: Int, modeFlags: Int): Int {
//        return PackageManager.PERMISSION_GRANTED
//    }
//
//    override fun checkUriPermission(uri: Uri?, readPermission: String?, writePermission: String?, pid: Int, uid: Int, modeFlags: Int): Int {
//        return PackageManager.PERMISSION_GRANTED
//    }
//
//    override fun checkUriPermissions(uris: MutableList<Uri>, pid: Int, uid: Int, modeFlags: Int): IntArray {
//        return uris.map { PackageManager.PERMISSION_GRANTED }.toIntArray()
//    }
//
//    override fun enforceCallingOrSelfPermission(permission: String, message: String?) {
//    }
//
//    override fun enforceCallingOrSelfUriPermission(uri: Uri?, modeFlags: Int, message: String?) {
//
//    }
//
//    override fun enforceCallingPermission(permission: String, message: String?) {
//
//    }
//
//    override fun enforceCallingUriPermission(uri: Uri?, modeFlags: Int, message: String?) {
//
//    }
//
//    override fun enforcePermission(permission: String, pid: Int, uid: Int, message: String?) {
//
//    }
//
//    override fun enforceUriPermission(uri: Uri?, pid: Int, uid: Int, modeFlags: Int, message: String?) {
//
//    }
//
//    override fun enforceUriPermission(uri: Uri?, readPermission: String?, writePermission: String?, pid: Int, uid: Int, modeFlags: Int, message: String?) {
//
//    }
//
//    override fun grantUriPermission(toPackage: String?, uri: Uri?, modeFlags: Int) {
//
//    }
//
//    /**
//     * 虚拟名称
//     */
//    override fun getPackageName(): String {
//        return pkg ?: super.getPackageName()
//    }
//
//
//}
