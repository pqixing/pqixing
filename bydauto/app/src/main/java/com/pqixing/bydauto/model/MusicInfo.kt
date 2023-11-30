package com.pqixing.bydauto.model

import android.content.ComponentName
import android.content.Context
import android.media.MediaMetadata
import android.media.session.MediaController
import android.media.session.MediaSessionManager
import android.media.session.PlaybackState
import com.pqixing.bydauto.App
import com.pqixing.bydauto.service.NTService
import com.pqixing.bydauto.utils.log
import com.pqixing.bydauto.utils.toast

class MusicInfo() : MediaSessionManager.OnActiveSessionsChangedListener {
    var pkg = Properties(""){""}
    var play = Properties(false){false}
    var song = Properties(""){""}
    var singer = Properties(""){""}

    private var controllers: List<MediaController> = listOf()

    private var callback = object : MediaController.Callback() {
        override fun onPlaybackStateChanged(state: PlaybackState?) {
            super.onPlaybackStateChanged(state)
            "onPlaybackStateChanged --- $state".log()

            updateInfo()
        }

        override fun onMetadataChanged(metadata: MediaMetadata?) {
            super.onMetadataChanged(metadata)
            "onMetadataChanged --- $metadata".log()
            updateInfo()
        }
    }

    private var update = Runnable {
        val curPlay = controllers.find { it.playbackState.isPlay() }
        if (curPlay == null) {
            play.setValue(false)
            return@Runnable
        }
        play.setValue(true)
        pkg.setValue(curPlay.packageName)
        val metadata = curPlay.metadata
        if (metadata != null) {
            song.setValue(metadata.getString(MediaMetadata.METADATA_KEY_TITLE))
            singer.setValue(metadata.getString(MediaMetadata.METADATA_KEY_ARTIST))
        }
        "update: ${pkg.getValue()},${play.getValue()},${song.getValue()},${singer.getValue()}".log()
    }

//    fun onMetadataChanged(metadata: MediaMetadata?) {
//        if (metadata != null) {
//            val trackName =
//                metadata.getString(MediaMetadata.METADATA_KEY_TITLE);
//            val artistName =
//                metadata.getString(MediaMetadata.METADATA_KEY_ARTIST);
//            val albumArtistName =
//                metadata.getString(MediaMetadata.METADATA_KEY_ALBUM_ARTIST);
//            val albumName =
//                metadata.getString(MediaMetadata.METADATA_KEY_ALBUM);
//            " MediaController $trackName , $artistName , $albumArtistName , $albumName ".log()
//        }
//    }

    private fun PlaybackState?.isPlay(): Boolean {
        if (this == null) return false
        return state == PlaybackState.STATE_FAST_FORWARDING || state == PlaybackState.STATE_REWINDING || state == PlaybackState.STATE_SKIPPING_TO_PREVIOUS || state == PlaybackState.STATE_SKIPPING_TO_NEXT || state == PlaybackState.STATE_SKIPPING_TO_QUEUE_ITEM || state == PlaybackState.STATE_BUFFERING || state == PlaybackState.STATE_CONNECTING || state == PlaybackState.STATE_PLAYING
    }

    fun onCreate(context: Context) = kotlin.runCatching {
        val service = context.getSystemService(MediaSessionManager::class.java)
        val comn = ComponentName(context, NTService::class.java)
        service.addOnActiveSessionsChangedListener(this, comn, App.mHandle)
        onActiveSessionsChanged(service.getActiveSessions(comn))

        pkg.observe { Const.SP_MUSIC_PKG = it }
    }.onFailure {
        it.printStackTrace()
        it.message?.toast()
    }

    fun onDestroy(context: Context) = kotlin.runCatching {
        val service = context.getSystemService(MediaSessionManager::class.java)
        service.removeOnActiveSessionsChangedListener(this)
    }.onFailure {
        it.printStackTrace()
        it.message?.toast()
    }

    override fun onActiveSessionsChanged(controllers: MutableList<MediaController>?) {
        "onActiveSessionsChanged ${controllers?.joinToString { it.packageName }}".log()
        this.controllers.forEach { it.unregisterCallback(callback) }
        this.controllers = controllers ?: return
        this.controllers.forEach { it.registerCallback(callback) }
        updateInfo()
    }

    private fun updateInfo() {
        App.mHandle.removeCallbacks(update)
        App.mHandle.postDelayed(update, 100)
    }

}
