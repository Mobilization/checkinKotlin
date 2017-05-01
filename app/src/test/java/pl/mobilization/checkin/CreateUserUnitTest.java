package pl.mobilization.checkin;

import com.google.firebase.FirebaseApp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import pl.mobilization.checkin.login.FirebaseLoginGateway;
import pl.mobilization.checkin.login.LoginGateway;
import pl.mobilization.checkin.login.User;

import static org.junit.Assert.*;


@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class CreateUserUnitTest {
    @Test
    public void userCreateIsCorrect() throws Exception {
        FirebaseApp.initializeApp(RuntimeEnvironment.application);
        LoginGateway loginGateway = new FirebaseLoginGateway();
        loginGateway.createUser("mariopce", "qazwsx").subscribe();
    }
}