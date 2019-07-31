package com.lounah.musicplayer2.core.imageloader

import android.content.Context
import android.widget.ImageView
import com.lounah.musicplayer2.core.ext.checkNotNull

object ImageLoader {
    fun with(context: Context): ImageRequest {
        return ImageRequest(context)
    }
}

class ImageRequest(private val context: Context) {
    private var url: String? = null
    private var target: ImageView? = null

    fun load(url: String): ImageRequest {
        this.url = url
        return this
    }

    fun into(imageView: ImageView): ResourceLoader {
        target = imageView
        return ResourceLoader(context, url.checkNotNull(), target.checkNotNull())
    }
}

class ResourceLoader(private val context: Context,
                     private val url: String,
                     private val target: ImageView) {

    private val bitmapCache = BitmapCache.instance

    init {
        bitmapCache[url]?.let(target::setImageBitmap) ?: run {
            downloadImageInternal()
        }
    }

    private fun downloadImageInternal() {

    }
}