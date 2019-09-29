package pl.mobilization.checkin.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.google.android.gms.common.api.internal.LifecycleActivity
import io.reactivex.SingleObserver
import io.reactivex.rxkotlin.subscribeBy
import mu.KotlinLogging
import pl.mobilization.checkin.R

class LoginActivity : AppCompatActivity() {
    private val logger = KotlinLogging.logger {}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val loginInput = findViewById(R.id.loginInput) as EditText
        val passwordInput = findViewById(R.id.passwordInput) as EditText
        val loginButton = findViewById(R.id.loginButton) as Button
        val presenter = LoginPresenterImpl()

        loginButton.setOnClickListener {
        presenter.login(loginInput.text.toString(), passwordInput.text.toString())
                .subscribeBy(
                        onSuccess = { Snackbar.make(loginButton, "Success " + it, Snackbar.LENGTH_SHORT).show()},
                        onError = {Snackbar.make(loginButton, "Error ${it.message}", Snackbar.LENGTH_SHORT).show()}
                )
        }
        val myComponents = MyComponent(lifecycle)
        val userData : LiveData<User> = MyLifeData()
        val fds = Observer{ u: User? -> println("user " + u) }
        userData.observe(this,fds);

    }

    class MyLifeData : LiveData<User>() {

    }

    override fun onStart() {
        super.onStart()
        //println("OnStart")
        //println("LC " + lifecycle.currentState)
    }

}

