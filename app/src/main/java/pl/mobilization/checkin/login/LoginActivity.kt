package pl.mobilization.checkin.login

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.widget.EditText
import android.widget.Toast
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
        val loginButton = findViewById(R.id.loginButton)
        val presenter = LoginPresenterImpl()
        loginButton.setOnClickListener {
        presenter.login(loginInput.text.toString(), passwordInput.text.toString())
                .subscribeBy(
                        onSuccess = { Snackbar.make(loginButton, "Success " + it, Snackbar.LENGTH_SHORT)},
                        onError = {logger.debug("error ", it) }
                )
        }

    }

}

