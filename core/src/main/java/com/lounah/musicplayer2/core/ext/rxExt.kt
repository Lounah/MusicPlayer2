package com.lounah.musicplayer2.core.ext

import io.reactivex.Observable
import io.reactivex.Single

fun <T> T.justObservable() = Observable.just(this)
fun <T> T.justSingle() = Single.just(this)