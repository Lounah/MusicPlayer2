package com.lounah.musicplayer2.core.arch

import io.reactivex.Observable

abstract class Action : () -> Unit

class Event

typealias EventObservable = Observable<*>