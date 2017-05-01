package pl.mobilization.checkin.login

import io.reactivex.observers.TestObserver
import junit.framework.TestCase
import org.junit.Assert.*
import org.junit.Test as test

/**
 * Created by mario on 01.05.17.
 */
class LoginSimpleUseCaseTest {

    @test
    fun login() {
        val testObserver = TestObserver.create<String>()
        val loginUseCase = LoginSimpleUseCase();
        val result = loginUseCase.login("mario", "qwerty");
        result.subscribe(testObserver)
        assertEquals("ok", testObserver.events[0][0])
    }

}