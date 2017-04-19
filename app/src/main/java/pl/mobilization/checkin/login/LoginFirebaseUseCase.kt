package pl.mobilization.checkin.login

import io.reactivex.Single
import pl.mobilization.checkin.LoginUseCase

/**
 * Created by mario on 19.04.17.
 */
class LoginFirebaseUseCase : LoginUseCase {
    override fun login(user: String, pass: String): Single<String> {
        return Single.just("ok");
    }

}