package cat.udl.gtidic.course2223.teacher.thehangman.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import cat.udl.gtidic.course2223.teacher.thehangman.R;

public class EndGameActivity extends AppCompatActivity {
    private static final long DELAY_MILLIS = 5000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);


        //findViewById(R.id.btTurnInit).setOnClickListener(view -> menu());

        boolean playerWinner = getIntent().getBooleanExtra("playerWinner", false);

        TextView tvResult = findViewById(R.id.txtResult);

        if (playerWinner) {
            tvResult.setText("¡Has ganado!");
        } else {
            tvResult.setText("Has perdido...");
        }
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            // Cambiar a la siguiente actividad
            goToNextActivity();
        }, DELAY_MILLIS);


    }

    /* private void menu()
     {
         Intent intent = new Intent(this, InitActivity.class);
         startActivity(intent);
     }*/
    private void goToNextActivity() {
        Intent intent = new Intent(this, InitActivity.class);
        startActivity(intent);
        finish();
    }
}