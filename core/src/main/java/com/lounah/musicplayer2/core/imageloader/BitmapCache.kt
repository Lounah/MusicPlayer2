package com.lounah.musicplayer2.core.imageloader

import android.graphics.Bitmap
import java.util.concurrent.ConcurrentHashMap

class BitmapCache private constructor() {
    private object Holder {
        val INSTANCE = BitmapCache()
    }

    companion object {
        val instance: BitmapCache by lazy { Holder.INSTANCE }
    }

    private val cache = ConcurrentHashMap<String, Bitmap>(10, 1.5f)
    private var allocatedSize: Long = 0L
    private var memLimit = Runtime.getRuntime().maxMemory() / 4

    @Synchronized
    operator fun get(key: String): Bitmap? = cache[key]

    @Synchronized
    operator fun set(key: String, bitmap: Bitmap) {
        if (cache.containsKey(key)) {
            allocatedSize -= getSizeInBytes(cache[key])
        }
        cache[key] = bitmap
        allocatedSize += getSizeInBytes(cache[key])
        checkSize()
    }

    fun clear() {
        cache.clear()
    }

    private fun checkSize() {
        if (allocatedSize > memLimit) {
            val cacheIterator = cache.entries.iterator()
            while (cacheIterator.hasNext()) {
                val entry = cacheIterator.next()
                allocatedSize -= getSizeInBytes(entry.value)
                cacheIterator.remove()
                if (allocatedSize <= memLimit)
                    break
            }
        }
    }

    private fun getSizeInBytes(bitmap: Bitmap?): Long
            = bitmap?.run { rowBytes * height.toLong() } ?: 0L
}