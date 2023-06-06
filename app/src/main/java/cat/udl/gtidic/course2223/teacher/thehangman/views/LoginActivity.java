package cat.udl.gtidic.course2223.teacher.thehangman.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import cat.udl.gtidic.course2223.teacher.thehangman.R;

public class LoginActivity extends AppCompatActivity {

    public static final String TAG = "Parcial2";
    EditText etEmail, etPassowrd;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViewById(R.id.btnLogin).setOnClickListener(v -> login());
        etEmail = findViewById(R.id.etEmail);
        etPassowrd = findViewById(R.id.etPassword);
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onStart() {
        super.onStart();
        reload();
    }

    /**
     * Realitza la petició de login a Firebase i quan respon crida a reload per refrescar la pantalla
     */
    private void login() {
        String email = etEmail.getText().toString();
        String password = etPassowrd.getText().toString();

        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this, task -> {
                if (task.isSuccessful()) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithEmail:success");
                    reload();
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithEmail:failure", task.getException());
                    Toast.makeText(LoginActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                    reload();
                }
            });
    }

    /**
     * S'encarrega de netejar els camps i de canviar d'activity si correspón
     * és a dir, quan l'usuari està logat
     */
    private void reload(){
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent i = new Intent(this, InitActivity.class);
            startActivity(i);
        }
        etEmail.setText("");
        etPassowrd.setText("");
    }

}