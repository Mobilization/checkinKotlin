package pl.mobilization.checkin.login

import io.reactivex.Single

/**
 * Created by mario on 12.04.17.
 */
interface LoginPresenter {

    fun login(login : String, password : String): Single<String>

    fun logout()

    fun getCurrentUser() : Single<User>

}



