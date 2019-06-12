package com.appandweb.multimoduleapp.library.common

abstract class Presenter<T1, T2> {
    open fun initialize() = Unit

    open fun resume() = Unit

    open fun pause() = Unit

    open fun destroy() {
        view = null
        navigator = null
    }

    var view: T1? = null
    var navigator: T2? = null
}