package pl.mobilization.checkin.login

import io.reactivex.Single

/**
 * Created by mario on 19.04.17.
 */
class LoginSimpleUseCase : LoginUseCase {

    override fun getCurrentUser(): Single<User> {
        return Single.just(User("Mariusz", "mariopce@gmail.com"))
    }

    override fun login(user: String, pass: String): Single<User> {
        return Single.just(User("Mariusz", "mariopce@gmail.com"));
    }

}