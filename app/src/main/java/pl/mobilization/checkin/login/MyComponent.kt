package pl.mobilization.checkin.login

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent

/**
 * Created by mario on 21.06.17.
 */
class MyComponent : LifecycleObserver {

    constructor(lifecycle: Lifecycle){
        lifecycle.addObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart(){
        println("on start")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop(){
        println("on stop")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun onAny(){
//        println("on any ")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate(){
        println("on create ")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy(){
        println("on onDestroy ")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause(){
        println("on onPause ")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume(){
        println("on onResume ")
    }


}