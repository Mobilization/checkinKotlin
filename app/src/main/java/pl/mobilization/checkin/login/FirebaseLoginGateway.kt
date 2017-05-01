package pl.mobilization.checkin.login

import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.OnFailureListener
import com.google.firebase.auth.FirebaseAuth
import io.reactivex.Single
import com.google.firebase.auth.FirebaseUser



/**
 * Created by mario on 01.05.17.
 */
class FirebaseLoginGateway : LoginGateway {

    override fun createUser(user: String, pass: String): Single<User> {
        return Single.create<User> { s ->
            val mAuth = FirebaseAuth.getInstance();
            mAuth.createUserWithEmailAndPassword(user, pass).addOnCompleteListener(OnCompleteListener {
                task ->
                if (task.isSuccessful){
                    val user = task.result.user
                    s.onSuccess(User(user.displayName.orEmpty(), user.email.orEmpty()))
                }else{
                    s.onError(IllegalStateException("Can not create user"))
                }
            }).addOnFailureListener(OnFailureListener { error ->  IllegalStateException(error)})
        }

    }

    override fun getCurrentUser(): Single<User> {
        val mAuth = FirebaseAuth.getInstance();
        val currentUser = mAuth.currentUser
        if (currentUser != null) {
            return Single.just(User(currentUser.displayName.orEmpty(), currentUser.email.orEmpty()))
        }else{
            return Single.error<User> { IllegalAccessError("User is not logged")};
        }
    }


}