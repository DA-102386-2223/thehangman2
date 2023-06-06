package cat.udl.gtidic.course2223.teacher.thehangman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.TextView;

public class EndGameActivity extends AppCompatActivity {

    private boolean isPlayerWinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);

        Intent i = getIntent();
        isPlayerWinner = i.getBooleanExtra("isPlayerWinner", false);

        TextView tv = findViewById(R.id.endGameTextView);

        if (isPlayerWinner) tv.setText("Has guanyat!");
        else tv.setText("Has perdut!");

        new CountDownTimer(5000, 1000) {
            public void onFinish() {
                finish();
            }
            public void onTick(long millisUntilFinished) {
            }
        }.start();
    }
}