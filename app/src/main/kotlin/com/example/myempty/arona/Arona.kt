// FUCK NEXON
// FUCK NEXON
// FUCK NEXON
package com.example.myempty.arona

import android.util.Log
import android.content.Context
import android.media.MediaPlayer
import kotlinx.coroutines.*

class Arona(private val context: Context) {
    private var count = 0
    private var mediaPlayer: MediaPlayer? = null
    public var height = 256
    public var width = 128
    
    private val audioFileList =
        arrayOf(
            "where_to_start_work_sensei",
            "sensei_can_start_work_there",
            "ask_sensei_to_start_work",
            "big_man_is_very_busy_ne",
            "the_thing_is_really_large",
            "wow_the_work_number_is_very_big",
            "arona_is_afraid_of_health",
            "come_on_together_sensei"
        )

    fun outputAudioMessage() {
        // 如果上一个音频还在播放就忽略点击
        if (mediaPlayer?.isPlaying == true) {
            return
        }

        mediaPlayer?.release()
        mediaPlayer = null

        val audioName = audioFileList[count]
        count = (count + 1) % audioFileList.size
        val resId = context.resources.getIdentifier(audioName, "raw", context.packageName)
        if (resId != 0) {
            mediaPlayer = MediaPlayer.create(context, resId)?.apply {
                start()
                setOnCompletionListener {
                    it.release()
                    mediaPlayer = null
                }
            }
        }
    }
    fun release() {
        mediaPlayer?.release()
        mediaPlayer = null
    }
}
class JunkLogger(
    private val scope: CoroutineScope
) {
    private val TAG = "[Hxh(CuSO4isVeryNice) Sensei]"
    public fun run() {
        scope.launch {
            while (true) {
                Log.w(TAG, "FUCK NEXON!")
                delay(800) // 协程挂起
            }
        }
    }
}