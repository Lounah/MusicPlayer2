package com.lounah.musicplayer2.core.ext

inline fun <reified T> T?.checkNotNull(): T {
    return this ?: error("${T::class.java.simpleName} can not be null.")
}