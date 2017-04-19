package pl.mobilization.checkin

import io.reactivex.Single

/**
 * Created by mario on 19.04.17.
 */
interface LoginUseCase {
    fun login(user: String, pass:String) : Single<String>
}