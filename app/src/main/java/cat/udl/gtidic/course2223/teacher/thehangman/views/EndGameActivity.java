package cat.udl.gtidic.course2223.teacher.thehangman.views;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import cat.udl.gtidic.course2223.teacher.thehangman.R;


import android.os.CountDownTimer;

import android.widget.TextView;


public class EndGameActivity extends AppCompatActivity {

    private TextView countdownText;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);

        countdownText = findViewById(R.id.countdown_text); // You need to have this TextView in your layout
        ImageView endGameImage = findViewById(R.id.end_game_image);

        Bundle extras = getIntent().getExtras();
        boolean playerWinner = extras.getBoolean("playerWinner");

        if (playerWinner) {
            endGameImage.setImageResource(R.drawable.youwin);
        } else {
            endGameImage.setImageResource(R.drawable.loser);
        }

        startCountdown();
    }

    private void startCountdown() {
        new CountDownTimer(5000, 1000) { // 5000 ms (or 5 seconds) with interval of 1000 ms (or 1 second)

            public void onTick(long millisUntilFinished) {
                countdownText.setText(String.valueOf(millisUntilFinished / 1000)); // update the countdown text
            }

            public void onFinish() {
                Intent intent = new Intent(EndGameActivity.this, InitActivity.class);
                startActivity(intent);
                finish();
            }
        }.start();
    }
}

