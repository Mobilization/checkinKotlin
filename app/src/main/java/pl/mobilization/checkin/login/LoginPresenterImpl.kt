package pl.mobilization.checkin.login

import io.reactivex.Single
import pl.mobilization.checkin.LoginUseCase


/**
 * Created by mario on 12.04.17.
 */
class LoginPresenterImpl : LoginPresenter {
    override fun getLoginUseCase() : LoginUseCase = LoginFirebaseUseCase()


    override fun login(login: String, password: String): Single<String> {
        return getLoginUseCase().login(login, password)
    }

    override fun logout() {

    }
}