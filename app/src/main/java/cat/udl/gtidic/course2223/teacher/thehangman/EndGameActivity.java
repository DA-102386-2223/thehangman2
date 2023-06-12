package cat.udl.gtidic.course2223.teacher.thehangman;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EndGameActivity extends AppCompatActivity {
    private boolean PlayerWinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.endgame);
        Intent i = getIntent();
        PlayerWinner = i.getBooleanExtra("isPlayerWinner", false);

        TextView tv = findViewById(R.id.endGameTextView);


        if (PlayerWinner) tv.setText("Has guanyat!");
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