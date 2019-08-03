package com.lounah.musicplayer2.core.filebrowser

import com.lounah.musicplayer2.core.ext.justObservable
import io.reactivex.Observable
import java.io.File

typealias CurrentDir = File

class DirectoriesProvider : (CurrentDir) -> Observable<List<File>> {

    override fun invoke(directory: CurrentDir): Observable<List<File>> {
        val subDirectories = directory.listFiles { dir, name -> File(dir, name).isDirectory }
        return subDirectories?.run {
            toList().justObservable()
        } ?: emptyList<File>().justObservable()
    }
}