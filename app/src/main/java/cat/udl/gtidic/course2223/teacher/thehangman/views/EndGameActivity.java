package cat.udl.gtidic.course2223.teacher.thehangman.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import cat.udl.gtidic.course2223.teacher.thehangman.R;

public class EndGameActivity extends AppCompatActivity {

    TextView resultat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);

        Boolean isPlayerWinner = getIntent().getBooleanExtra("isPlayerWinner",false);

        resultat = findViewById(R.id.resultat);

        if(isPlayerWinner)
        {
            resultat.setText("Has guanyat!");
        }
        else
        {
            resultat.setText("Has perdut!");
        }

        findViewById(R.id.buttonmenu).setOnClickListener(view -> {
            Intent intent = new Intent(this,InitActivity.class);
            startActivity(intent);
            finish();
        });


    }
}