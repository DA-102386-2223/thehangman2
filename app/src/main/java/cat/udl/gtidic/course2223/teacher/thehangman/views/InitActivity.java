package cat.udl.gtidic.course2223.teacher.thehangman.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import cat.udl.gtidic.course2223.teacher.thehangman.R;

public class InitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init);
        findViewById(R.id.btnStartGame).setOnClickListener(view -> startGame());
        findViewById(R.id.btnPreviousScores).setOnClickListener(view -> showPreviousScores());
        findViewById(R.id.btnHowToPlay).setOnClickListener(view -> howToPlay());
        findViewById(R.id.btnLogout).setOnClickListener(view -> logout());
    }

    /**
     * Inicia un nou joc
     */
    private void startGame(){
        Intent i = new Intent(this, GameActivity.class);
        startActivity(i);
    }

    /**
     * Mostra una reciclerView amb els resultats anteriors
     */
    private void showPreviousScores() {
        Intent i = new Intent(this, PreviousScoresActivity.class);
        startActivity(i);
    }

    /**
     * Mostra l'activity de com jugar al joc
     */
    private void howToPlay() {
        Intent i = new Intent(this, HowToPlayActivity.class);
        startActivity(i);
    }

    /**
     * Deslogueja l'usuari de Firebase
     */
    private void logout() {
        Toast.makeText(this, R.string.notDeveloped, Toast.LENGTH_SHORT ).show();
    }
}