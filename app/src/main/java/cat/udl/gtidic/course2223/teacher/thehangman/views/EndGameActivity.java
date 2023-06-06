package cat.udl.gtidic.course2223.teacher.thehangman.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import cat.udl.gtidic.course2223.teacher.thehangman.R;

public class EndGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);


        findViewById(R.id.btTurnInit).setOnClickListener(view -> menu());

        boolean playerWinner = getIntent().getBooleanExtra("playerWinner", false);

        TextView tvResult = findViewById(R.id.txtResult);

        if (playerWinner) {
            tvResult.setText("¡Has ganado!");
        } else {
            tvResult.setText("Has perdido...");
        }


    }
    private void menu()
    {
        Intent intent = new Intent(this, InitActivity.class);
        startActivity(intent);
    }
}