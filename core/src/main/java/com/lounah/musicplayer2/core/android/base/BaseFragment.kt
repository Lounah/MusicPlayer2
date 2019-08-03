package com.lounah.musicplayer2.core.android.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.lounah.musicplayer2.core.android.lifecycle.Event
import com.lounah.musicplayer2.core.android.lifecycle.Event.*
import io.reactivex.subjects.PublishSubject

abstract class BaseFragment : Fragment() {

    private val eventSubject: PublishSubject<Event> = PublishSubject.create()

    val bindEvent = eventSubject.filter { it == CREATE }
    val unBindEvent = eventSubject.filter { it == DESTROY }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutRes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        eventSubject.onNext(CREATE)
    }

    override fun onResume() {
        super.onResume()
        eventSubject.onNext(RESUME)
    }

    override fun onStart() {
        super.onStart()
        eventSubject.onNext(START)
    }

    override fun onStop() {
        super.onStop()
        eventSubject.onNext(STOP)
    }

    override fun onPause() {
        super.onPause()
        eventSubject.onNext(PAUSE)
    }

    override fun onDestroy() {
        super.onDestroy()
        eventSubject.onNext(DESTROY)
    }

    abstract val layoutRes: Int
}