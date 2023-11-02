package com.pqixing.bydauto.service

import android.app.Service
import android.content.ComponentName
import android.content.Intent
import android.media.MediaMetadata
import android.media.session.MediaController
import android.media.session.MediaSessionManager
import android.media.session.PlaybackState
import android.os.IBinder
import android.util.Log
import com.pqixing.bydauto.utils.SettingManager
import com.pqixing.bydauto.utils.log

class MainService : Service() {
    override fun onBind(intent: Intent?): IBinder? = null

    val call = object : MediaController.Callback() {
        override fun onPlaybackStateChanged(state: PlaybackState?) {
            super.onPlaybackStateChanged(state)
            state?.log(tag = "MediaController")
        }

        override fun onMetadataChanged(metadata: MediaMetadata?) {
            super.onMetadataChanged(metadata)
            if (metadata != null) {
                val trackName =
                    metadata.getString(MediaMetadata.METADATA_KEY_TITLE);
                val artistName =
                    metadata.getString(MediaMetadata.METADATA_KEY_ARTIST);
                val albumArtistName =
                    metadata.getString(MediaMetadata.METADATA_KEY_ALBUM_ARTIST);
                val albumName =
                    metadata.getString(MediaMetadata.METADATA_KEY_ALBUM);
                " MediaController $trackName , $artistName , $albumArtistName , $albumName ".log()
            }
        }

    }

    override fun onCreate() {
        super.onCreate()
        SettingManager.updateCurSettings(this)
        val service = getSystemService(MediaSessionManager::class.java)
        val comn = ComponentName(this, NTService::class.java)
        val listener = MediaSessionManager.OnActiveSessionsChangedListener { registSessionCallBack(it) }
        service.addOnActiveSessionsChangedListener(listener, comn)
        registSessionCallBack(service.getActiveSessions(comn))
    }

    private fun registSessionCallBack(callbacks: List<MediaController>?) {
        callbacks ?: return
        callbacks.joinToString { it.toString() }.log(tag = "MediaController")
        callbacks.forEach {
            it.unregisterCallback(call)
            it.registerCallback(call) }
    }

    override fun onDestroy() {
        super.onDestroy()
        SettingManager.getSettings(this).forEach { it.onDestroy(this) }
    }

    override fun enforceCallingOrSelfPermission(permission: String, message: String?) {
        Log.w("MainService", "enforceCallingOrSelfPermission: $permission")
    }

    override fun enforceCallingPermission(permission: String, message: String?) {
        Log.w("MainService", "enforceCallingPermission: ")
    }
}