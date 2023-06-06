package cat.udl.gtidic.course2223.teacher.thehangman.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import cat.udl.gtidic.course2223.teacher.thehangman.R;
import cat.udl.gtidic.course2223.teacher.thehangman.views.GameActivity;
import cat.udl.gtidic.course2223.teacher.thehangman.views.HowToPlayActivity;
import cat.udl.gtidic.course2223.teacher.thehangman.views.LoginActivity;
import cat.udl.gtidic.course2223.teacher.thehangman.views.PreviousScoresActivity;

public class InitActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init);

        mAuth = FirebaseAuth.getInstance();

        findViewById(R.id.btnStartGame).setOnClickListener(view -> startGame());
        findViewById(R.id.btnPreviousScores).setOnClickListener(view -> showPreviousScores());
        findViewById(R.id.btnHowToPlay).setOnClickListener(view -> howToPlay());
        findViewById(R.id.btnLogout).setOnClickListener(view -> logout());
    }

    /**
     * Inicia un nuevo juego
     */
    private void startGame(){
        Intent i = new Intent(this, GameActivity.class);
        startActivity(i);
    }

    /**
     * Muestra una RecyclerView con los resultados anteriores
     */
    private void showPreviousScores() {
        Intent i = new Intent(this, PreviousScoresActivity.class);
        startActivity(i);
    }

    /**
     * Muestra la actividad de cómo jugar al juego
     */
    private void howToPlay() {
        Intent i = new Intent(this, HowToPlayActivity.class);
        startActivity(i);
    }

    /**
     * Desloguea al usuario de Firebase
     */
    private void logout() {
        mAuth.signOut();
        Toast.makeText(this, "Logged out successfully", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
