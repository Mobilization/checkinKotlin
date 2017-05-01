package pl.mobilization.checkin.login

import io.reactivex.Single

/**
 * Created by mario on 19.04.17.
 */
interface LoginUseCase {
    fun login(user: String, pass:String) : Single<User>
    fun getCurrentUser(): Single<User>
}