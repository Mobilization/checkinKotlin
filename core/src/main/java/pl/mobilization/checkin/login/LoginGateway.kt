package pl.mobilization.checkin.login

import io.reactivex.Single

/**
 * Created by mario on 01.05.17.
 */
interface LoginGateway {
    fun getCurrentUser(): Single<User>
    fun createUser(user: String, pass: String) : Single<User>
}