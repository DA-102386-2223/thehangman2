package cat.udl.gtidic.course2223.teacher.thehangman.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import cat.udl.gtidic.course2223.teacher.thehangman.R;
import cat.udl.gtidic.course2223.teacher.thehangman.views.InitActivity;



public class ResultatActivity extends AppCompatActivity {

    private CountDownTimer countDownTimer;
    private static final long WAIT_TIME = 5000; // 5 segons

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat);
        boolean playerWinner = getIntent().getBooleanExtra("playerWinner", false);
        TextView tvResultMessage = findViewById(R.id.tvResultMessage);

        if (playerWinner) {
            tvResultMessage.setText("¡Has guanyat!");
        } else {
            tvResultMessage.setText("¡Has perdut!");
        }

        //Button btnBackToInit = findViewById(R.id.btnBackToInit);
        //btnBackToInit.setOnClickListener(new View.OnClickListener() {
        // @Override
          //  public void onClick(View v) {
            //    Intent intent = new Intent(ResultatActivity.this, InitActivity.class);
              //  startActivity(intent);
                //finish();
          //  }
        //});

        // Iniciar el temporitzador
        countDownTimer = new CountDownTimer(WAIT_TIME, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(ResultatActivity.this, InitActivity.class);
                startActivity(intent);
                finish();
            }
        }.start();

    }







}