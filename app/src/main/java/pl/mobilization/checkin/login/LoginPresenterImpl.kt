package pl.mobilization.checkin.login

import io.reactivex.Single


/**
 * Created by mario on 12.04.17.
 */
class LoginPresenterImpl : LoginPresenter {

    val loginUseCase = LoginNetUseCase(FirebaseLoginGateway())

    override fun getCurrentUser(): Single<User> {
        return loginUseCase.getCurrentUser()
    }

    override fun login(login: String, password: String): Single<String> {
        return loginUseCase.login(login, password).map { u -> u.toString() }
    }

    override fun logout() {

    }
}