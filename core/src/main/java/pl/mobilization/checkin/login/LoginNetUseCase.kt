package pl.mobilization.checkin.login

import io.reactivex.Single

/**
 * Created by mario on 19.04.17.
 */
class LoginNetUseCase(var loginGateway: LoginGateway) : LoginUseCase {

    override fun getCurrentUser(): Single<User> {
        return loginGateway.getCurrentUser();
    }

    override fun login(user: String, pass: String): Single<User> {
        return loginGateway.createUser(user, pass)
    }

}
